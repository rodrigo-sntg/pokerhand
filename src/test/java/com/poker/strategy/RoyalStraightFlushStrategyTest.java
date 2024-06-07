package com.poker.strategy;

import com.poker.enums.CardValue;
import com.poker.enums.Suits;
import com.poker.model.Card;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RoyalStraightFlushStrategyTest {

    @Test
    void testRoyalStraightFlush() {
        List<Card> royalFlush = Arrays.asList(
                new Card(CardValue.TEN, Suits.HEART.getSuit()),
                new Card(CardValue.JACK, Suits.HEART.getSuit()),
                new Card(CardValue.QUEEN, Suits.HEART.getSuit()),
                new Card(CardValue.KING, Suits.HEART.getSuit()),
                new Card(CardValue.ACE, Suits.HEART.getSuit())
        );
        RoyalStraightFlushStrategy strategy = new RoyalStraightFlushStrategy();
        assertTrue(strategy.isValid(royalFlush));
    }

    @Test
    void testNotRoyalStraightFlush() {
        List<Card> notRoyalFlush = Arrays.asList(
                new Card(CardValue.TEN, Suits.HEART.getSuit()),
                new Card(CardValue.JACK, Suits.HEART.getSuit()),
                new Card(CardValue.QUEEN, Suits.HEART.getSuit()),
                new Card(CardValue.KING, Suits.HEART.getSuit()),
                new Card(CardValue.NINE, Suits.HEART.getSuit())
        );
        RoyalStraightFlushStrategy strategy = new RoyalStraightFlushStrategy();
        assertFalse(strategy.isValid(notRoyalFlush));
    }
}