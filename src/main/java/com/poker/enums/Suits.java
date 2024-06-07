package com.poker.enums;

public enum Suits {
    HEART("Heart"),
    SPADE("Spade"),
    DIAMOND("Diamond"),
    CLUB("Club");

    private String suit;

    Suits(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }
}
