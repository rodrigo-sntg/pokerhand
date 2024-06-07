package com.poker.helpers;

import com.poker.model.Card;
import com.poker.enums.CardValue;
import com.poker.enums.Suits;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SequenceHelperTest {

    @Test
    void testIsSequence() {
        List<Card> sequence = Arrays.asList(
                new Card(CardValue.TWO, Suits.HEART.getSuit()),
                new Card(CardValue.THREE, Suits.DIAMOND.getSuit()),
                new Card(CardValue.FOUR, Suits.HEART.getSuit()),
                new Card(CardValue.FIVE, Suits.SPADE.getSuit()),
                new Card(CardValue.SIX, Suits.CLUB.getSuit())
        );
        assertTrue(SequenceHelper.isSequence(sequence));

        List<Card> nonSequence = Arrays.asList(
                new Card(CardValue.TWO, Suits.HEART.getSuit()),
                new Card(CardValue.THREE, Suits.DIAMOND.getSuit()),
                new Card(CardValue.FIVE, Suits.HEART.getSuit()),
                new Card(CardValue.SIX, Suits.SPADE.getSuit()),
                new Card(CardValue.SEVEN, Suits.CLUB.getSuit())
        );
        assertFalse(SequenceHelper.isSequence(nonSequence));
    }
}