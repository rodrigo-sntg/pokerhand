package com.poker.strategy;

import com.poker.enums.CardValue;
import com.poker.enums.Suits;
import com.poker.model.Card;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ThreeOfAKindStrategyTest {

    @Test
    void testThreeOfAKind() {
        List<Card> threeOfAKind = Arrays.asList(
                new Card(CardValue.FOUR, Suits.HEART.getSuit()),
                new Card(CardValue.FOUR, Suits.DIAMOND.getSuit()),
                new Card(CardValue.FOUR, Suits.CLUB.getSuit()),
                new Card(CardValue.SEVEN, Suits.SPADE.getSuit()),
                new Card(CardValue.EIGHT, Suits.CLUB.getSuit())
        );
        ThreeOfAKindStrategy strategy = new ThreeOfAKindStrategy();
        assertTrue(strategy.isValid(threeOfAKind));
    }

    @Test
    void testNotThreeOfAKind() {
        List<Card> notThreeOfAKind = Arrays.asList(
                new Card(CardValue.FOUR, Suits.HEART.getSuit()),
                new Card(CardValue.FOUR, Suits.DIAMOND.getSuit()),
                new Card(CardValue.FIVE, Suits.CLUB.getSuit()),
                new Card(CardValue.SEVEN, Suits.SPADE.getSuit()),
                new Card(CardValue.EIGHT, Suits.CLUB.getSuit())
        );
        ThreeOfAKindStrategy strategy = new ThreeOfAKindStrategy();
        assertFalse(strategy.isValid(notThreeOfAKind));
    }
}