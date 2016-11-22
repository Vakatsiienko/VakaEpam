package com.vaka.epam.homework.week4.task22Observer;

/**
 * Created by Iaroslav on 11/22/2016.
 */
public interface POObserveSubject {

    void attachSub(PostOfficeListener listener, NewsMediaType newsMediaType);

    void detachSubFromMediaType(PostOfficeListener listener, NewsMediaType newsMediaType);

    void detachSub(PostOfficeListener listener);

    void sendUpdates(NewsMediaPrint print);

}
