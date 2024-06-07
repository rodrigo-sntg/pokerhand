package com.poker.model;

import com.poker.enums.CardValue;

public record Card(CardValue value, String suit) implements Comparable<Card> {
    @Override
    public int compareTo(Card o) {
        int numberComparison = Integer.compare(this.value.getNumber(), o.value.getNumber());
        if (numberComparison != 0) {
            return numberComparison;
        }
        return this.suit.compareTo(o.suit);
    }
}
