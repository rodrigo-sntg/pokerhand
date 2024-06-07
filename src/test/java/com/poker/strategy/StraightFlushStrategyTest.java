package com.poker.strategy;

import com.poker.enums.CardValue;
import com.poker.enums.Suits;
import com.poker.model.Card;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StraightFlushStrategyTest {

    @Test
    void testStraightFlush() {
        List<Card> straightFlush = Arrays.asList(
                new Card(CardValue.SIX, Suits.SPADE.getSuit()),
                new Card(CardValue.SEVEN, Suits.SPADE.getSuit()),
                new Card(CardValue.EIGHT, Suits.SPADE.getSuit()),
                new Card(CardValue.NINE, Suits.SPADE.getSuit()),
                new Card(CardValue.TEN, Suits.SPADE.getSuit())
        );
        StraightFlushStrategy strategy = new StraightFlushStrategy();
        assertTrue(strategy.isValid(straightFlush));
    }

    @Test
    void testNotStraightFlush() {
        List<Card> notStraightFlush = Arrays.asList(
                new Card(CardValue.SIX, Suits.SPADE.getSuit()),
                new Card(CardValue.SEVEN, Suits.SPADE.getSuit()),
                new Card(CardValue.EIGHT, Suits.SPADE.getSuit()),
                new Card(CardValue.NINE, Suits.SPADE.getSuit()),
                new Card(CardValue.JACK, Suits.SPADE.getSuit())
        );
        StraightFlushStrategy strategy = new StraightFlushStrategy();
        assertFalse(strategy.isValid(notStraightFlush));
    }
}