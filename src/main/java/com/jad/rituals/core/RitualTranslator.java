package com.jad.rituals.core;

import com.jad.rituals.model.Ritual;

public class RitualTranslator {

    public Ritual translate(String cryptic) {
        Ritual ritual = new Ritual(cryptic);

        // TODO : découper en paires
        // TODO : appliquer les règles
        // TODO : ajouter les ActionInstance dans ritual.addAction(...)

        return ritual;
    }
}