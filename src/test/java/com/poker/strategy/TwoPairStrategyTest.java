package com.poker.strategy;

import com.poker.enums.CardValue;
import com.poker.enums.Suits;
import com.poker.model.Card;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TwoPairStrategyTest {

    @Test
    void testTwoPair() {
        List<Card> twoPair = Arrays.asList(
                new Card(CardValue.THREE, Suits.HEART.getSuit()),
                new Card(CardValue.THREE, Suits.DIAMOND.getSuit()),
                new Card(CardValue.FOUR, Suits.CLUB.getSuit()),
                new Card(CardValue.FOUR, Suits.SPADE.getSuit()),
                new Card(CardValue.FIVE, Suits.CLUB.getSuit())
        );
        TwoPairStrategy strategy = new TwoPairStrategy();
        assertTrue(strategy.isValid(twoPair));
    }

    @Test
    void testNotTwoPair() {
        List<Card> notTwoPair = Arrays.asList(
                new Card(CardValue.THREE, Suits.HEART.getSuit()),
                new Card(CardValue.THREE, Suits.DIAMOND.getSuit()),
                new Card(CardValue.FOUR, Suits.CLUB.getSuit()),
                new Card(CardValue.FIVE, Suits.SPADE.getSuit()),
                new Card(CardValue.SIX, Suits.CLUB.getSuit())
        );
        TwoPairStrategy strategy = new TwoPairStrategy();
        assertFalse(strategy.isValid(notTwoPair));
    }
}