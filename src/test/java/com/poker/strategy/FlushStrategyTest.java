package com.poker.strategy;

import com.poker.enums.CardValue;
import com.poker.enums.Suits;
import com.poker.model.Card;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FlushStrategyTest {

    @Test
    void testFlush() {
        List<Card> flush = Arrays.asList(
                new Card(CardValue.TWO, Suits.HEART.getSuit()),
                new Card(CardValue.FOUR, Suits.HEART.getSuit()),
                new Card(CardValue.SIX, Suits.HEART.getSuit()),
                new Card(CardValue.EIGHT, Suits.HEART.getSuit()),
                new Card(CardValue.TEN, Suits.HEART.getSuit())
        );
        FlushStrategy strategy = new FlushStrategy();
        assertTrue(strategy.isValid(flush));
    }

    @Test
    void testNotFlush() {
        List<Card> notFlush = Arrays.asList(
                new Card(CardValue.TWO, Suits.HEART.getSuit()),
                new Card(CardValue.FOUR, Suits.HEART.getSuit()),
                new Card(CardValue.SIX, Suits.HEART.getSuit()),
                new Card(CardValue.EIGHT, Suits.HEART.getSuit()),
                new Card(CardValue.TEN, Suits.CLUB.getSuit())
        );
        FlushStrategy strategy = new FlushStrategy();
        assertFalse(strategy.isValid(notFlush));
    }

}