package com.poker.strategy;

import com.poker.enums.Hands;
import com.poker.helpers.FlushHelper;
import com.poker.model.Card;


import java.util.List;

public class FlushStrategy implements HandStrategy{
    @Override
    public boolean isValid(List<Card> cards) {
        return FlushHelper.isFlush(cards);
    }

    @Override
    public String getHandName() {
        return Hands.FLUSH.getHand();
    }

    @Override
    public int getPriority() {
        return Hands.FLUSH.getPriority();
    }
}
