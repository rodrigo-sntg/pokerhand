package com.poker.validator;



import com.poker.factory.HandStrategyFactory;
import com.poker.model.Card;
import com.poker.strategy.HandStrategy;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class HandEvaluator {
    public static String evaluateHand(List<Card> cards) {
        if (!isValidHand(cards)) {
            return "Invalid hand";
        }

        List<HandStrategy> strategies = HandStrategyFactory.createStrategies();
        PriorityQueue<HandStrategy> heap = new PriorityQueue<>((s1, s2) -> Integer.compare(s1.getPriority(), s2.getPriority()));

        for (HandStrategy strategy : strategies) {
            if (strategy.isValid(cards)) {
                heap.add(strategy);
            }
        }

        HandStrategy bestStrategy = heap.poll();
        return bestStrategy != null ? bestStrategy.getHandName() : "High card";
    }

    private static boolean isValidHand(List<Card> cards) {
        if (cards.size() != 5) {
            return false;
        }

        Set<Card> uniqueCards = new HashSet<>(cards);
        return uniqueCards.size() == 5;
    }
}