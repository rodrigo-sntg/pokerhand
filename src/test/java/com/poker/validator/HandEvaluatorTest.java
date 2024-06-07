package com.poker.validator;

import com.poker.model.Card;
import com.poker.enums.CardValue;
import com.poker.enums.Suits;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HandEvaluatorTest {

    @Test
    void testEvaluateHandWithInvalidHandSize() {
        List<Card> invalidHand = Arrays.asList(
                new Card(CardValue.TWO, Suits.CLUB.getSuit()),
                new Card(CardValue.THREE, Suits.DIAMOND.getSuit())
        );
        assertEquals("Invalid hand", HandEvaluator.evaluateHand(invalidHand));
    }

    @Test
    void testEvaluateHandWithDuplicateCards() {
        List<Card> invalidHand = Arrays.asList(
                new Card(CardValue.TWO, Suits.CLUB.getSuit()),
                new Card(CardValue.TWO, Suits.CLUB.getSuit()),
                new Card(CardValue.THREE, Suits.DIAMOND.getSuit()),
                new Card(CardValue.FOUR, Suits.HEART.getSuit()),
                new Card(CardValue.FIVE, Suits.SPADE.getSuit())
        );
        assertEquals("Invalid hand", HandEvaluator.evaluateHand(invalidHand));
    }

    @Test
    void testEvaluateHandWithRoyalFlush() {
        List<Card> royalFlush = Arrays.asList(
                new Card(CardValue.TEN, Suits.HEART.getSuit()),
                new Card(CardValue.JACK, Suits.HEART.getSuit()),
                new Card(CardValue.QUEEN, Suits.HEART.getSuit()),
                new Card(CardValue.KING, Suits.HEART.getSuit()),
                new Card(CardValue.ACE, Suits.HEART.getSuit())
        );
        assertEquals("Royal Flush", HandEvaluator.evaluateHand(royalFlush));
    }

    @Test
    void testEvaluateHandWithStraightFlush() {
        List<Card> straightFlush = Arrays.asList(
                new Card(CardValue.SIX, Suits.SPADE.getSuit()),
                new Card(CardValue.SEVEN, Suits.SPADE.getSuit()),
                new Card(CardValue.EIGHT, Suits.SPADE.getSuit()),
                new Card(CardValue.NINE, Suits.SPADE.getSuit()),
                new Card(CardValue.TEN, Suits.SPADE.getSuit())
        );
        assertEquals("Straight Flush", HandEvaluator.evaluateHand(straightFlush));
    }

    @Test
    void testEvaluateHandWithFourOfAKind() {
        List<Card> fourOfAKind = Arrays.asList(
                new Card(CardValue.NINE, Suits.HEART.getSuit()),
                new Card(CardValue.NINE, Suits.DIAMOND.getSuit()),
                new Card(CardValue.NINE, Suits.CLUB.getSuit()),
                new Card(CardValue.NINE, Suits.SPADE.getSuit()),
                new Card(CardValue.TWO, Suits.HEART.getSuit())
        );
        assertEquals("Four of a Kind", HandEvaluator.evaluateHand(fourOfAKind));
    }

    @Test
    void testEvaluateHandWithFullHouse() {
        List<Card> fullHouse = Arrays.asList(
                new Card(CardValue.THREE, Suits.HEART.getSuit()),
                new Card(CardValue.THREE, Suits.DIAMOND.getSuit()),
                new Card(CardValue.THREE, Suits.CLUB.getSuit()),
                new Card(CardValue.TWO, Suits.SPADE.getSuit()),
                new Card(CardValue.TWO, Suits.HEART.getSuit())
        );
        assertEquals("Full House", HandEvaluator.evaluateHand(fullHouse));
    }

    @Test
    void testEvaluateHandWithFlush() {
        List<Card> flush = Arrays.asList(
                new Card(CardValue.TWO, Suits.HEART.getSuit()),
                new Card(CardValue.FOUR, Suits.HEART.getSuit()),
                new Card(CardValue.SIX, Suits.HEART.getSuit()),
                new Card(CardValue.EIGHT, Suits.HEART.getSuit()),
                new Card(CardValue.TEN, Suits.HEART.getSuit())
        );
        assertEquals("Flush", HandEvaluator.evaluateHand(flush));
    }

    @Test
    void testEvaluateHandWithStraight() {
        List<Card> straight = Arrays.asList(
                new Card(CardValue.TWO, Suits.HEART.getSuit()),
                new Card(CardValue.THREE, Suits.DIAMOND.getSuit()),
                new Card(CardValue.FOUR, Suits.HEART.getSuit()),
                new Card(CardValue.FIVE, Suits.SPADE.getSuit()),
                new Card(CardValue.SIX, Suits.CLUB.getSuit())
        );
        assertEquals("Straight", HandEvaluator.evaluateHand(straight));
    }

    @Test
    void testEvaluateHandWithThreeOfAKind() {
        List<Card> threeOfAKind = Arrays.asList(
                new Card(CardValue.FOUR, Suits.HEART.getSuit()),
                new Card(CardValue.FOUR, Suits.DIAMOND.getSuit()),
                new Card(CardValue.FOUR, Suits.CLUB.getSuit()),
                new Card(CardValue.SEVEN, Suits.SPADE.getSuit()),
                new Card(CardValue.EIGHT, Suits.CLUB.getSuit())
        );
        assertEquals("Three of a Kind", HandEvaluator.evaluateHand(threeOfAKind));
    }

    @Test
    void testEvaluateHandWithTwoPair() {
        List<Card> twoPair = Arrays.asList(
                new Card(CardValue.THREE, Suits.HEART.getSuit()),
                new Card(CardValue.THREE, Suits.DIAMOND.getSuit()),
                new Card(CardValue.FOUR, Suits.CLUB.getSuit()),
                new Card(CardValue.FOUR, Suits.SPADE.getSuit()),
                new Card(CardValue.FIVE, Suits.CLUB.getSuit())
        );
        assertEquals("Two Pair", HandEvaluator.evaluateHand(twoPair));
    }

    @Test
    void testEvaluateHandWithOnePair() {
        List<Card> onePair = Arrays.asList(
                new Card(CardValue.SEVEN, Suits.HEART.getSuit()),
                new Card(CardValue.SEVEN, Suits.DIAMOND.getSuit()),
                new Card(CardValue.NINE, Suits.CLUB.getSuit()),
                new Card(CardValue.TEN, Suits.SPADE.getSuit()),
                new Card(CardValue.JACK, Suits.CLUB.getSuit())
        );
        assertEquals("One Pair", HandEvaluator.evaluateHand(onePair));
    }

    @Test
    void testEvaluateHandWithHighCard() {
        List<Card> highCard = Arrays.asList(
                new Card(CardValue.TWO, Suits.HEART.getSuit()),
                new Card(CardValue.FIVE, Suits.DIAMOND.getSuit()),
                new Card(CardValue.SEVEN, Suits.CLUB.getSuit()),
                new Card(CardValue.NINE, Suits.SPADE.getSuit()),
                new Card(CardValue.KING, Suits.CLUB.getSuit())
        );
        assertEquals("High card", HandEvaluator.evaluateHand(highCard));
    }
}