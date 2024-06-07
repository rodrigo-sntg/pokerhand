package com.poker.enums;

public enum Hands {
    ROYAL_FLUSH("Royal Flush", 1),
    STRAIGHT_FLUSH("Straight Flush", 2),
    FOUR_OF_A_KIND("Four of a Kind", 3),
    FULL_HOUSE("Full House", 4),
    FLUSH("Flush", 5),
    STRAIGHT("Straight", 6),
    THREE_OF_A_KIND("Three of a Kind", 7),
    TWO_PAIR("Two Pair", 8),
    ONE_PAIR("One Pair", 9),
    HIGH_CARD("High Card", 10);

    private String hand;
    private int priority;

    Hands(String hand, int priority) {
        this.hand = hand;
        this.priority = priority;
    }

    public String getHand() {
        return hand;
    }

    public int getPriority() {
        return priority;
    }
}
