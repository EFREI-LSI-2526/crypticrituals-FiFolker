package com.jad.rituals.core;

import com.jad.rituals.model.Action;
import com.jad.rituals.model.ActionInstance;
import com.jad.rituals.model.Ritual;

import java.util.ArrayList;
import java.util.List;

public class RitualTranslator {

    public Ritual translate(String cryptic) {
        Ritual ritual = new Ritual(cryptic);


        int length = ritual.getCrypticString().length();
        String ritualCryptic = ritual.getCrypticString().replaceAll("\\s", "");
        int n = 2;

        ActionInstance toAdd = null;
        for(int i = 0; i < length; i += n){
            if(ritualCryptic.length() - i < 2) break;

            String currAction = ritualCryptic.substring(i, Math.min(length, i+n));

            char c1 = currAction.charAt(0);
            char c2 = currAction.charAt(1);

            int index = ((int) c1 + 3 * (int) c2) % Action.values().length;

            Action action = Action.values()[index];
            ActionInstance actionInstance = ActionInstance.of(action);

            switch(c2){
                case '!':
                    // On l'ajoute 2 fois pour !
                    ritual.addAction(actionInstance);
                    ritual.addAction(actionInstance);
                    break;
                case '?':
                    final int size = ritual.getActions().size();
                    if(size == 0){
                        toAdd = actionInstance;
                    }else{
                        ritual.addAction(size-1, actionInstance);
                    }
                    break;
                case '#':
                    ritual.addAction(actionInstance);
                    ActionInstance ChantVerset = ActionInstance.of(Action.CHANT_VERSE);
                    ritual.addAction(ChantVerset);
                    break;
                case '%':
                    ritual.addAction(actionInstance);
                    ActionInstance wait = ActionInstance.of(Action.WAIT, c1);
                    ritual.addAction(wait);
                    break;
                default:
                    ritual.addAction(actionInstance);
                    break;
            }


        }

        if(toAdd != null) ritual.addAction(toAdd);

        return ritual;
    }
}