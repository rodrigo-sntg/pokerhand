package com.poker.strategy;

import com.poker.enums.Hands;
import com.poker.helpers.CountNumbersHelper;
import com.poker.model.Card;
import java.util.List;

public class FullHouseStrategy implements HandStrategy{
    @Override
    public boolean isValid(List<Card> cards) {
        return CountNumbersHelper.isFullHouse(cards);
    }

    @Override
    public String getHandName() {
        return Hands.FULL_HOUSE.getHand();
    }

    @Override
    public int getPriority() {
        return Hands.FULL_HOUSE.getPriority();
    }
}
