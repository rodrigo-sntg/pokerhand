package com.poker.strategy;

import com.poker.enums.Hands;
import com.poker.helpers.SequenceHelper;
import com.poker.model.Card;

import java.util.List;

public class StraightStrategy implements HandStrategy{
    @Override
    public boolean isValid(List<Card> cards) {
        return SequenceHelper.isSequence(cards);
    }

    @Override
    public String getHandName() {
        return Hands.STRAIGHT.getHand();
    }

    @Override
    public int getPriority() {
        return Hands.STRAIGHT.getPriority();
    }
}
