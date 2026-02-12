package com.jad.rituals.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ritual {
    private final String crypticString;
    private final List<ActionInstance> actions = new ArrayList<>();

    public Ritual(final String crypticString) {
        this.crypticString = crypticString;
    }

    public final void addAction(final ActionInstance actionInstance) {
        this.actions.add(actionInstance);
    }

    public final void addAction(final int insertPos,final ActionInstance actionInstance) {
        this.actions.add(insertPos, actionInstance);
    }

    @Override
    public final String toString() {
        return "Ritual{" +
                "crypticString='" + this.getCrypticString() + '\'' +
                ", actions=" + this.getActions() +
                '}';
    }

    public final String getCrypticString() {
        return this.crypticString;
    }

    public final List<ActionInstance> getActions() {
        return Collections.unmodifiableList(this.actions);
    }
}