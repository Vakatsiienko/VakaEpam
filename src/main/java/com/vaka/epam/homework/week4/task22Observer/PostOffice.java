package com.vaka.epam.homework.week4.task22Observer;

import lombok.AllArgsConstructor;

import java.util.*;

/**
 * Created by Iaroslav on 11/22/2016.
 */
@AllArgsConstructor
public class PostOffice implements POObserveSubject {

    private Map<PostOfficeListener, Set<NewsMediaType>> mediaTypeByListeners;

    private List<NewsMediaPrint> prints;


    public void applyMediaPrint(NewsMediaPrint print) {
        prints.add(print);
        sendUpdates(print);
    }

    @Override
    public void attachSub(PostOfficeListener listener, NewsMediaType mediaType) {
        mediaTypeByListeners.putIfAbsent(listener, new HashSet<>());
        mediaTypeByListeners.get(listener).add(mediaType);
    }

    @Override
    public void detachSub(PostOfficeListener listener) {
        mediaTypeByListeners.remove(listener);
    }

    @Override
    public void detachSubFromMediaType(PostOfficeListener listener, NewsMediaType mediaType) {
        mediaTypeByListeners.get(listener).remove(mediaType);
    }

    @Override
    public void sendUpdates(NewsMediaPrint print) {
        mediaTypeByListeners.keySet().stream()
                .filter(map -> mediaTypeByListeners.get(map).contains(print.getMediaType()))
                .forEach(listener-> listener.update(print));

    }
}
