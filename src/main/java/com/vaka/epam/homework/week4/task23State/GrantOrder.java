package com.vaka.epam.homework.week4.task23State;

import com.vaka.epam.homework.week4.task23State.grantstates.GrantNewState;
import com.vaka.epam.homework.week4.task23State.grantstates.GrantOnConsiderationState;
import com.vaka.epam.homework.week4.task23State.grantstates.GrantRecallState;
import com.vaka.epam.homework.week4.task23State.grantstates.GrantState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Iaroslav on 11/22/2016.
 */
@Getter
@Setter
@NoArgsConstructor
public class GrantOrder {

    private int grantRating;

    private String stateCommentary;

    private GrantState state = new GrantNewState();

    public boolean recallGrant() {
        if (state instanceof GrantOnConsiderationState)
            return false;
        else {
            state = new GrantRecallState();
            return true;
        }
    }

    public void commit() {
        if (state instanceof GrantNewState || state instanceof GrantRecallState)
            state.approveToNext(this);
    }
}

