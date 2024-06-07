package com.poker;

import com.poker.enums.CardValue;
import com.poker.enums.Suits;
import com.poker.model.Card;
import com.poker.validator.HandEvaluator;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardValue.TWO, Suits.CLUB.getSuit()));
        cards.add(new Card(CardValue.TWO, Suits.DIAMOND.getSuit()));
        cards.add(new Card(CardValue.TWO, Suits.HEART.getSuit()));
        cards.add(new Card(CardValue.TWO, Suits.SPADE.getSuit()));
        cards.add(new Card(CardValue.THREE, Suits.CLUB.getSuit()));

        String hand = HandEvaluator.evaluateHand(cards);
        System.out.println(hand);
    }
}
