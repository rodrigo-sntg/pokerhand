package com.poker.strategy;

import com.poker.enums.CardValue;
import com.poker.enums.Suits;
import com.poker.model.Card;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PairStrategyTest {

    @Test
    void testPair() {
        List<Card> onePair = Arrays.asList(
                new Card(CardValue.SEVEN, Suits.HEART.getSuit()),
                new Card(CardValue.SEVEN, Suits.DIAMOND.getSuit()),
                new Card(CardValue.NINE, Suits.CLUB.getSuit()),
                new Card(CardValue.TEN, Suits.SPADE.getSuit()),
                new Card(CardValue.JACK, Suits.CLUB.getSuit())
        );
        PairStrategy strategy = new PairStrategy();
        assertTrue(strategy.isValid(onePair));
    }

    @Test
    void testNotPair() {
        List<Card> notPair = Arrays.asList(
                new Card(CardValue.SEVEN, Suits.HEART.getSuit()),
                new Card(CardValue.EIGHT, Suits.DIAMOND.getSuit()),
                new Card(CardValue.NINE, Suits.CLUB.getSuit()),
                new Card(CardValue.TEN, Suits.SPADE.getSuit()),
                new Card(CardValue.JACK, Suits.CLUB.getSuit())
        );
        PairStrategy strategy = new PairStrategy();
        assertFalse(strategy.isValid(notPair));
    }
}