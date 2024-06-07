package com.poker.naive;


import com.poker.enums.CardValue;
import com.poker.enums.Suits;
import com.poker.model.Card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardValue.TWO, Suits.CLUB));
        cards.add(new Card(CardValue.TWO, Suits.DIAMOND));
        cards.add(new Card(CardValue.TWO, Suits.HEART));
        cards.add(new Card(CardValue.TWO, Suits.SPADE));
        cards.add(new Card(CardValue.THREE, Suits.CLUB));

        List<String> hands = listHand(cards);
        hands.forEach(System.out::println);

    }

    public static List<String> listHand(List<Card> cards) {
        List<String> listOfHands = new ArrayList<>();
        cards.sort(Card::compareTo);
        Map<String, Integer> suitCounterMap = new HashMap<>();
        suitCounterMap.put(Suits.HEART.getSuit(), 0);
        suitCounterMap.put(Suits.SPADE.getSuit(), 0);
        suitCounterMap.put(Suits.CLUB.getSuit(), 0);
        suitCounterMap.put(Suits.DIAMOND.getSuit(), 0);
        int sequenceCounter = 1;

        Map<Integer, Integer> numberCount = new HashMap<>();

        Card card = cards.get(0);
        int lastNumber = card.value().getNumber();
        suitCounterMap.put(card.suit().getSuit(), suitCounterMap.get(card.suit().getSuit()) + 1);
        numberCount.put(card.value().getNumber(), numberCount.getOrDefault(card.value().getNumber() + 1, 1));
        boolean hasAce = card.value().getNumber() == 14;

        SequenceCounter result = getResult(cards, hasAce, suitCounterMap, numberCount, lastNumber, sequenceCounter);


        String hand = checkStraightAndFlush(result.sequenceCounter(), suitCounterMap, card, result.hasAce());
        if(!"".equals(hand)){
            listOfHands.add(hand);
            return listOfHands;
        }


        listOfHands.addAll(numberOfPairs(numberCount));
        if (checkFullHouse(listOfHands)) {
            listOfHands.remove("pair");
            listOfHands.remove("three of a kind");
            listOfHands.add("full house");
        }



        return listOfHands;
    }

    private static SequenceCounter getResult(List<Card> cards, boolean hasAce, Map<String, Integer> suitCounterMap, Map<Integer, Integer> numberCount, int lastNumber, int sequenceCounter) {
        for (int j = 1; j < cards.size(); j++) {
            Card c = cards.get(j);

            hasAce = hasAce ? hasAce : c.value().getNumber() == 14;

            suitCounterMap.put(c.suit().getSuit(), suitCounterMap.get(c.suit().getSuit()) + 1);
            numberCount.put(c.value().getNumber(), numberCount.getOrDefault(c.value().getNumber(), 0) + 1);
            if((lastNumber + 1) == c.value().getNumber()) {
                sequenceCounter++;
                lastNumber = c.value().getNumber();
            } else {

                sequenceCounter = 1;
            }
        }
        SequenceCounter result = new SequenceCounter(sequenceCounter, hasAce);
        return result;
    }

    private record SequenceCounter(int sequenceCounter, boolean hasAce) {
    }

    public static String checkStraightAndFlush(int sequenceCounter, Map<String, Integer> suitCounterMap, Card card, boolean hasAce) {
        if(sequenceCounter == 5 && suitCounterMap.get(card.suit().getSuit()) == 5 && hasAce)
            return "royal straight flush";
        else if(sequenceCounter == 5 && suitCounterMap.get(card.suit().getSuit()) == 5)
            return "straight flush";
        else if(sequenceCounter == 5){
            return "straight";
        } else if(suitCounterMap.values().contains(5))
            return "flush";
        else
            return "";
    }

    public static List<String> numberOfPairs(Map<Integer, Integer> numberCount) {
        List<String> listOfPairs = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : numberCount.entrySet()) {
            if(entry.getValue() == 2) {
                if (listOfPairs.contains("pair")){
                    listOfPairs.remove("pair");
                    listOfPairs.add("two pairs");
                }
                else
                    listOfPairs.add("pair");
            }
            else if(entry.getValue() == 3)
                listOfPairs.add("three of a kind");
            else if(entry.getValue() == 4)
                listOfPairs.add("four of a kind");
        }
        return listOfPairs;
    }

    public static boolean checkFullHouse(List<String> hands) {
        boolean hasPair = false;
        boolean hasThreeOfAKind = false;
        for(String hand : hands){
            if(hand == "pair" )
                hasPair = true;
            else if(hand == "three of a kind")
                hasThreeOfAKind = true;
        }
        return hasPair && hasThreeOfAKind;
    }

    public static boolean checkTwoPairs(List<String> hands) {

        if(hands.size() == 2 && hands.getFirst() == "pair" && hands.get(1) == "pair")
            return true;
        return false;

    }

    public static boolean checkFlush(Map<String, Integer> suitCount) {

        for(Integer count : suitCount.values()) {
            if(count == 5)
                return true;
        }

        return false;

    }

}