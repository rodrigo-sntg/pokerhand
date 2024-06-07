package com.poker.strategy;

import com.poker.enums.Hands;
import com.poker.helpers.FlushHelper;
import com.poker.helpers.SequenceHelper;
import com.poker.model.Card;

import java.util.List;

public class StraightFlushStrategy implements HandStrategy{
    @Override
    public boolean isValid(List<Card> cards) {
        if (cards.size() != 5) {
            return false;
        }


        cards.sort(Card::compareTo);

        if (!FlushHelper.isFlush(cards)) {
            return false;
        }

        return SequenceHelper.isSequence(cards);
    }

    @Override
    public String getHandName() {
        return Hands.STRAIGHT_FLUSH.getHand();
    }

    @Override
    public int getPriority() {
        return Hands.STRAIGHT_FLUSH.getPriority();
    }
}
