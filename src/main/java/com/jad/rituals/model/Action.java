package com.jad.rituals.model;

public enum Action {
    TRACE_RUNE("Tracer une rune", 120),
    CHANT_VERSE("Chanter un verset", 200),
    OPEN_PORTAL("Ouvrir un portail", 500),
    CLOSE_PORTAL("Fermer un portail", 300),
    DRAW_SIGIL("Dessiner un sigil", 150),
    RECITE_INCANTATION("Psalmodier une incantation", 250),
    POUR_OCTOPUS_BLOOD("Verser du sang de poulpe", 180),
    WAVE_INCENSE("Agiter l’encens", 100),
    INVOKE_WHISPER("Invoquer un chuchotement", 220),
    DAMPEN_RESONANCE("Atténuer la résonance", 160),
    SUMMON_ASTRAL_ECHO("Invoquer un écho astral", 400),
    PURIFY_CIRCLE("Purifier le cercle", 210),
    STABILIZE_FLOW("Stabiliser le flux", 190),
    MEASURE_OCCULT_FLOW("Mesurer le flux occulte", 130),
    SEAL_FISSURE("Sceller une fissure", 260),
    MARK_OFFERING("Marquer l’offrande", 140),
    BREAK_TALISMAN("Briser un talisman", 170),
    CHARGE_RELIC("Charger une relique", 230),
    CONSULT_NECRONOMICON("Consulter le Necronomicon", 350),
    ENGRAVE_FORBIDDEN_SYMBOL("Graver un symbole interdit", 280),
    APPLY_BLACK_OIL("Appliquer l’huile noire", 160),
    CHANNEL_ENERGY("Canaliser l’énergie", 300),
    WAIT("Attendre", 0);

    private final String name;
    private final int defaultDurationMs;

    Action(String name, int defaultDurationMs) {
        this.name = name;
        this.defaultDurationMs = defaultDurationMs;
    }

    public static int getLength(){
        return Action.values().length;
    }

    @Override
    public final String toString() {
        return "Action{" +
                "name='" + this.getName() + '\'' +
                ", defaultDurationMs=" + this.getDefaultDurationMs() +
                "} " + super.toString();
    }

    public final String getName() {
        return this.name;
    }

    public final int getDefaultDurationMs() {
        return this.defaultDurationMs;
    }
}
