package com.poker.strategy;

import com.poker.enums.Hands;
import com.poker.helpers.CountNumbersHelper;
import com.poker.model.Card;

import java.util.List;

public class PairStrategy implements HandStrategy{
    @Override
    public boolean isValid(List<Card> cards) {
        return CountNumbersHelper.isPair(cards);
    }

    @Override
    public String getHandName() {
        return Hands.ONE_PAIR.getHand();
    }

    @Override
    public int getPriority() {
        return Hands.ONE_PAIR.getPriority();
    }


}
