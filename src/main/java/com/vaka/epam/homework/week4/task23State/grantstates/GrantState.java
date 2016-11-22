package com.vaka.epam.homework.week4.task23State.grantstates;

import com.vaka.epam.homework.week4.task23State.GrantOrder;

/**
 * Created by Iaroslav on 11/22/2016.
 */
public interface GrantState {

    void approveToNext(GrantOrder grant);
}
