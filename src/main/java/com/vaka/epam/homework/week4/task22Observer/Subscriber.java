package com.vaka.epam.homework.week4.task22Observer;

import lombok.AllArgsConstructor;

import java.util.List;

/**
 * Created by Iaroslav on 11/22/2016.
 */
@AllArgsConstructor
public class Subscriber implements PostOfficeListener {

    private List<NewsMediaPrint> prints;

    @Override
    public void update(NewsMediaPrint print) {
        prints.add(print);
    }

}
