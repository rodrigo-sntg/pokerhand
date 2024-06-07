package com.poker.strategy;


import com.poker.model.Card;

import java.util.List;

public interface HandStrategy {
    boolean isValid(List<Card> cards);
    String getHandName();
    int getPriority();

}
