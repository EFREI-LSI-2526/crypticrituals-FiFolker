package com.jad.rituals.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.IntSupplier;

public final class ActionInstance {
    private static final Map<Action, ActionInstance> SINGLETONS = new EnumMap<>(Action.class);
    private final Action action;
    private final IntSupplier durationSupplier;

    private ActionInstance(Action action, IntSupplier durationSupplier) {
        this.action = action;
        this.durationSupplier = durationSupplier;
    }

    public static ActionInstance of(final Action action) {
        return ActionInstance.SINGLETONS.computeIfAbsent(action, a -> new ActionInstance(a, a::getDefaultDurationMs));
    }

    public static ActionInstance of(final Action action, int ms) {
        return new ActionInstance(action, () -> ms);
    }

    public int getDuration() {
        return this.durationSupplier.getAsInt();
    }

    // Je pense que c'est une mauvaise façon de faire, mais ça corrige la loi de demeter
    public String getActionName() { return this.action.getName(); }

    @Override
    public final String toString() {
        return "ActionInstance{" +
                "action=" + this.getAction() +
                ", durationSupplier=" + this.durationSupplier +
                '}';
    }

    public Action getAction() {
        return this.action;
    }
}