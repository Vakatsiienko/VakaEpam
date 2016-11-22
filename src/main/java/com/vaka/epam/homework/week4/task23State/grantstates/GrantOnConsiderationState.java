package com.vaka.epam.homework.week4.task23State.grantstates;

import com.vaka.epam.homework.week4.task23State.GrantOrder;

/**
 * Created by Iaroslav on 11/22/2016.
 */
public class GrantOnConsiderationState implements GrantState {
    @Override
    public void approveToNext(GrantOrder grant) {
        grant.setStateCommentary("Grant is already considering, please wait.");
    }
}
