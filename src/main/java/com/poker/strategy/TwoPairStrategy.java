package com.poker.strategy;

import com.poker.enums.Hands;
import com.poker.helpers.CountNumbersHelper;
import com.poker.model.Card;

import java.util.List;
import java.util.Map;

public class TwoPairStrategy implements HandStrategy{
    @Override
    public boolean isValid(List<Card> cards) {
        return CountNumbersHelper.isTwoPairs(cards);
    }

    @Override
    public String getHandName() {
        return Hands.TWO_PAIR.getHand();
    }

    @Override
    public int getPriority() {
        return Hands.TWO_PAIR.getPriority();
    }
}
