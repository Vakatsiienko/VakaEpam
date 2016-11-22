package com.vaka.epam.homework.week4.task23State.grantstates;

import com.vaka.epam.homework.week4.task23State.GrantOrder;

/**
 * Created by Iaroslav on 11/22/2016.
 */
public class GrantConsideringState implements GrantState {

    private boolean busy;

    @Override
    public void approveToNext(GrantOrder grant) {
        if (committeeIsBusy())
            grant.setState(new GrantPostponedState());
        busy = true;
        grant.setState(new GrantOnConsiderationState());
        if (considerationThings(grant))
            grant.setState(new GrantApprovedState());
        else grant.setState(new GrantRejectedState());

    }

    private boolean considerationThings(GrantOrder grant) {
        try {
            Thread.sleep(1000);
            if (grant.getGrantRating() < 7) {
                grant.setStateCommentary("All is good!");
                return true;
            } else {
                grant.setStateCommentary("Sorry, it's not enough");
                return false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            busy = false;
        }
        return false;
    }

    private boolean committeeIsBusy() {
        return busy;
    }
}
