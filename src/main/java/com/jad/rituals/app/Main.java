package com.jad.rituals.app;

import com.jad.rituals.core.RitualEvaluator;
import com.jad.rituals.core.RitualExecutor;
import com.jad.rituals.core.RitualFileLoader;
import com.jad.rituals.model.Ritual;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public enum Main {
    ;

    public static void main(String[] args) throws IOException, URISyntaxException {
        RitualExecutor executor = new RitualExecutor();
        RitualEvaluator evaluator = new RitualEvaluator();
        RitualFileLoader loader = new RitualFileLoader();

        List<Ritual> rituals = loader.loadFromResources("rituals.txt");

        for (Ritual ritual : rituals) {
            System.out.println("Rituel : " + ritual.getCrypticString());
            executor.executeAll(ritual.getActions());
            System.out.println("Score : " + evaluator.evaluate(ritual));
        }
    }

}