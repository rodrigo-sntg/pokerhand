package com.poker.helpers;

import com.poker.model.Card;
import com.poker.enums.CardValue;
import com.poker.enums.Suits;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FlushHelperTest {

    @Test
    void testIsFlush() {
        List<Card> flush = Arrays.asList(
                new Card(CardValue.TWO, Suits.HEART.getSuit()),
                new Card(CardValue.THREE, Suits.HEART.getSuit()),
                new Card(CardValue.FOUR, Suits.HEART.getSuit()),
                new Card(CardValue.FIVE, Suits.HEART.getSuit()),
                new Card(CardValue.SIX, Suits.HEART.getSuit())
        );
        assertTrue(FlushHelper.isFlush(flush));

        List<Card> nonFlush = Arrays.asList(
                new Card(CardValue.TWO, Suits.HEART.getSuit()),
                new Card(CardValue.THREE, Suits.HEART.getSuit()),
                new Card(CardValue.FOUR, Suits.CLUB.getSuit()),
                new Card(CardValue.FIVE, Suits.HEART.getSuit()),
                new Card(CardValue.SIX, Suits.HEART.getSuit())
        );
        assertFalse(FlushHelper.isFlush(nonFlush));
    }
}