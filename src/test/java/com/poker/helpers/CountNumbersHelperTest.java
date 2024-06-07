package com.poker.helpers;

import com.poker.enums.CardValue;
import com.poker.enums.Suits;
import com.poker.model.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CountNumbersHelperTest {

    @Test
    void testCountNumbers() {
        List<Card> cards = Arrays.asList(
                new Card(CardValue.TWO, Suits.CLUB.getSuit()),
                new Card(CardValue.THREE, Suits.DIAMOND.getSuit()),
                new Card(CardValue.FOUR, Suits.HEART.getSuit()),
                new Card(CardValue.FIVE, Suits.SPADE.getSuit()),
                new Card(CardValue.SIX, Suits.CLUB.getSuit())
        );
        Map<Integer, Integer> countMap = CountNumbersHelper.countNumbers(cards);
        assertEquals(1, countMap.get(CardValue.TWO.getNumber()));
        assertEquals(1, countMap.get(CardValue.THREE.getNumber()));
        assertEquals(1, countMap.get(CardValue.FOUR.getNumber()));
        assertEquals(1, countMap.get(CardValue.FIVE.getNumber()));
        assertEquals(1, countMap.get(CardValue.SIX.getNumber()));
    }

    @Test
    void testIsFourOfAKind() {
        List<Card> cards = Arrays.asList(
                new Card(CardValue.TWO, Suits.CLUB.getSuit()),
                new Card(CardValue.TWO, Suits.DIAMOND.getSuit()),
                new Card(CardValue.TWO, Suits.HEART.getSuit()),
                new Card(CardValue.TWO, Suits.SPADE.getSuit()),
                new Card(CardValue.THREE, Suits.CLUB.getSuit())
        );
        assertTrue(CountNumbersHelper.isFourOfAKind(cards));
    }

    @Test
    void testIsFullHouse() {
        List<Card> cards = Arrays.asList(
                new Card(CardValue.THREE, Suits.CLUB.getSuit()),
                new Card(CardValue.THREE, Suits.DIAMOND.getSuit()),
                new Card(CardValue.THREE, Suits.HEART.getSuit()),
                new Card(CardValue.TWO, Suits.SPADE.getSuit()),
                new Card(CardValue.TWO, Suits.CLUB.getSuit())
        );
        assertTrue(CountNumbersHelper.isFullHouse(cards));
    }

    @Test
    void testIsThreeOfAKind() {
        List<Card> cards = Arrays.asList(
                new Card(CardValue.TWO, Suits.CLUB.getSuit()),
                new Card(CardValue.TWO, Suits.DIAMOND.getSuit()),
                new Card(CardValue.TWO, Suits.HEART.getSuit()),
                new Card(CardValue.FOUR, Suits.SPADE.getSuit()),
                new Card(CardValue.FIVE, Suits.CLUB.getSuit())
        );
        assertTrue(CountNumbersHelper.isThreeOfAKind(cards));
    }

    @Test
    void testIsPair() {
        List<Card> cards = Arrays.asList(
                new Card(CardValue.TWO, Suits.CLUB.getSuit()),
                new Card(CardValue.TWO, Suits.DIAMOND.getSuit()),
                new Card(CardValue.THREE, Suits.HEART.getSuit()),
                new Card(CardValue.FOUR, Suits.SPADE.getSuit()),
                new Card(CardValue.FIVE, Suits.CLUB.getSuit())
        );
        assertTrue(CountNumbersHelper.isPair(cards));
    }

    @Test
    void testIsTwoPairs() {
        List<Card> cards = Arrays.asList(
                new Card(CardValue.TWO, Suits.CLUB.getSuit()),
                new Card(CardValue.TWO, Suits.DIAMOND.getSuit()),
                new Card(CardValue.THREE, Suits.HEART.getSuit()),
                new Card(CardValue.THREE, Suits.SPADE.getSuit()),
                new Card(CardValue.FOUR, Suits.CLUB.getSuit())
        );
        assertTrue(CountNumbersHelper.isTwoPairs(cards));
    }
}