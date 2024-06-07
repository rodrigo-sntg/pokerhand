package com.poker.strategy;



import com.poker.enums.Hands;
import com.poker.helpers.CountNumbersHelper;
import com.poker.model.Card;

import java.util.List;

public class FourOfAKindStrategy implements HandStrategy{

    @Override
    public boolean isValid(List<Card> cards) {
        return CountNumbersHelper.isFourOfAKind(cards);
    }

    @Override
    public String getHandName() {
        return Hands.FOUR_OF_A_KIND.getHand();
    }

    @Override
    public int getPriority() {
        return Hands.FOUR_OF_A_KIND.getPriority();
    }
}
