package com.poker.strategy;

import com.poker.enums.CardValue;
import com.poker.enums.Suits;
import com.poker.model.Card;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FullHouseStrategyTest {

    @Test
    void testFullHouse() {
        List<Card> fullHouse = Arrays.asList(
                new Card(CardValue.THREE, Suits.HEART.getSuit()),
                new Card(CardValue.THREE, Suits.DIAMOND.getSuit()),
                new Card(CardValue.THREE, Suits.CLUB.getSuit()),
                new Card(CardValue.TWO, Suits.SPADE.getSuit()),
                new Card(CardValue.TWO, Suits.HEART.getSuit())
        );
        FullHouseStrategy strategy = new FullHouseStrategy();
        assertTrue(strategy.isValid(fullHouse));
    }

    @Test
    void testNotFullHouse() {
        List<Card> notFullHouse = Arrays.asList(
                new Card(CardValue.THREE, Suits.HEART.getSuit()),
                new Card(CardValue.THREE, Suits.DIAMOND.getSuit()),
                new Card(CardValue.TWO, Suits.CLUB.getSuit()),
                new Card(CardValue.TWO, Suits.SPADE.getSuit()),
                new Card(CardValue.FOUR, Suits.HEART.getSuit())
        );
        FullHouseStrategy strategy = new FullHouseStrategy();
        assertFalse(strategy.isValid(notFullHouse));
    }
}