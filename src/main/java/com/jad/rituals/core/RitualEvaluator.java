package com.jad.rituals.core;

import com.jad.rituals.model.ActionInstance;
import com.jad.rituals.model.Ritual;

public class RitualEvaluator {
    static final int MAX_DURATION = 10_000;

    public int evaluate(Ritual ritual) {

        int totalDuration = ritual.getActions().stream()
                .mapToInt(ActionInstance::getDuration)
                .sum();

        return Math.max(0, RitualEvaluator.MAX_DURATION - totalDuration);
    }
}