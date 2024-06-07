package com.poker.strategy;

import com.poker.enums.CardValue;
import com.poker.enums.Suits;
import com.poker.model.Card;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FourOfAKindStrategyTest {

    @Test
    void testFourOfAKind() {
        List<Card> fourOfAKind = Arrays.asList(
                new Card(CardValue.NINE, Suits.HEART.getSuit()),
                new Card(CardValue.NINE, Suits.DIAMOND.getSuit()),
                new Card(CardValue.NINE, Suits.CLUB.getSuit()),
                new Card(CardValue.NINE, Suits.SPADE.getSuit()),
                new Card(CardValue.TWO, Suits.HEART.getSuit())
        );
        FourOfAKindStrategy strategy = new FourOfAKindStrategy();
        assertTrue(strategy.isValid(fourOfAKind));
    }

    @Test
    void testNotFourOfAKind() {
        List<Card> notFourOfAKind = Arrays.asList(
                new Card(CardValue.NINE, Suits.HEART.getSuit()),
                new Card(CardValue.NINE, Suits.DIAMOND.getSuit()),
                new Card(CardValue.NINE, Suits.CLUB.getSuit()),
                new Card(CardValue.EIGHT, Suits.SPADE.getSuit()),
                new Card(CardValue.TWO, Suits.HEART.getSuit())
        );
        FourOfAKindStrategy strategy = new FourOfAKindStrategy();
        assertFalse(strategy.isValid(notFourOfAKind));
    }
}