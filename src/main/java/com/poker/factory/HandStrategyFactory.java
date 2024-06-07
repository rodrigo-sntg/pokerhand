package com.poker.factory;

import com.poker.strategy.*;

import java.util.ArrayList;
import java.util.List;

public class HandStrategyFactory {
    public static List<HandStrategy> createStrategies() {
        List<HandStrategy> strategies = new ArrayList<>();
        strategies.add(new RoyalStraightFlushStrategy());
        strategies.add(new StraightFlushStrategy());
        strategies.add(new FourOfAKindStrategy());
        strategies.add(new FullHouseStrategy());
        strategies.add(new FlushStrategy());
        strategies.add(new StraightStrategy());
        strategies.add(new ThreeOfAKindStrategy());
        strategies.add(new TwoPairStrategy());
        strategies.add(new PairStrategy());
        return strategies;
    }
}