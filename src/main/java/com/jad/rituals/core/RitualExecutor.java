package com.jad.rituals.core;

import com.jad.rituals.model.ActionInstance;

public class RitualExecutor {
    public final void executeAll(Iterable<ActionInstance> actions) {
        for (ActionInstance actionInstance : actions) {
            this.execute(actionInstance);
        }
    }

    public final void execute(ActionInstance actionInstance) {
        System.out.println("-> " + actionInstance.getAction().getName() + "...");
        try {
            Thread.sleep(actionInstance.getDuration());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
