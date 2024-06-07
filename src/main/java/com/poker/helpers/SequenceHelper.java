package com.poker.helpers;

import com.poker.model.Card;

import java.util.List;

public class SequenceHelper {

    public static boolean isSequence(List<Card> cards) {

        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i + 1).value().getNumber() != cards.get(i).value().getNumber() + 1) {
                return false;
            }
        }
        return true;
    }
}
