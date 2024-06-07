package com.poker.strategy;

import com.poker.enums.Hands;
import com.poker.helpers.FlushHelper;
import com.poker.model.Card;

import java.util.List;

public class RoyalStraightFlushStrategy implements HandStrategy{
    @Override
    public boolean isValid(List<Card> cards) {
        if (cards.size() != 5) {
            return false;
        }

        // Ordene as cartas
        cards.sort(Card::compareTo);

        // Verifique se as cartas são 10, J, Q, K, A
        int[] royalSequence = {10, 11, 12, 13, 14};
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).value().getNumber() != royalSequence[i]) {
                return false;
            }
        }

        return FlushHelper.isFlush(cards);
    }

    @Override
    public String getHandName() {
        return Hands.ROYAL_FLUSH.getHand();
    }

    @Override
    public int getPriority() {
        return Hands.ROYAL_FLUSH.getPriority();
    }
}
