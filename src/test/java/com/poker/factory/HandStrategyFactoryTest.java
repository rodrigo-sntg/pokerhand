package com.poker.factory;

import com.poker.strategy.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class HandStrategyFactoryTest {

    @Test
    void testCreateStrategies() {
        List<HandStrategy> strategies = HandStrategyFactory.createStrategies();

        assertEquals(9, strategies.size());

        Set<Class<? extends HandStrategy>> strategyClasses = strategies.stream()
                .map(HandStrategy::getClass)
                .collect(Collectors.toSet());

        assertTrue(strategyClasses.contains(RoyalStraightFlushStrategy.class));
        assertTrue(strategyClasses.contains(StraightFlushStrategy.class));
        assertTrue(strategyClasses.contains(FourOfAKindStrategy.class));
        assertTrue(strategyClasses.contains(FullHouseStrategy.class));
        assertTrue(strategyClasses.contains(FlushStrategy.class));
        assertTrue(strategyClasses.contains(StraightStrategy.class));
        assertTrue(strategyClasses.contains(ThreeOfAKindStrategy.class));
        assertTrue(strategyClasses.contains(TwoPairStrategy.class));
        assertTrue(strategyClasses.contains(PairStrategy.class));
    }
}