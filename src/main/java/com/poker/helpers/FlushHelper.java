package com.poker.helpers;

import com.poker.model.Card;

import java.util.List;

public class FlushHelper {

    public static boolean isFlush(List<Card> cards) {
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i + 1).suit().getSuit() != cards.get(i).suit().getSuit()) {
                return false;
            }
        }
        return true;
    }
}
