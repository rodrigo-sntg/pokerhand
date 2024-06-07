package com.poker.helpers;

import com.poker.model.Card;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountNumbersHelper {
    public static Map<Integer, Integer> countNumbers(List<Card> cards) {
        Map<Integer, Integer> numberCount = new HashMap<>();
        for (Card card : cards) {
            numberCount.put(card.value().getNumber(), numberCount.getOrDefault(card.value().getNumber(), 0) + 1);
        }
        return numberCount;
    }

    // metodo para dizer se é um full house
    public static boolean isFullHouse(List<Card> cards) {
        Map<Integer, Integer> numberCount = countNumbers(cards);
        return numberCount.containsValue(3) && numberCount.containsValue(2);
    }


    public static boolean isFourOfAKind(List<Card> cards) {
        Map<Integer, Integer> numberCount = countNumbers(cards);
        return numberCount.containsValue(4);
    }

    public static boolean isThreeOfAKind(List<Card> cards) {
        Map<Integer, Integer> numberCount = countNumbers(cards);
        return numberCount.containsValue(3);
    }

    public static boolean isPair(List<Card> cards) {
        Map<Integer, Integer> numberCount = countNumbers(cards);
        return numberCount.containsValue(2);
    }

    public static boolean isTwoPairs(List<Card> cards) {
        Map<Integer, Integer> numberCount = countNumbers(cards);
        boolean hasPair = false;
        for(int i : numberCount.values()){
            if(i == 2){
                if(hasPair){
                    return true;
                }
                hasPair = true;
            }
        }

        return false;
    }

}
