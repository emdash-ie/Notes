public enum ConcreteRoamer implements Roamer {
    PACK_ROAMER(Behaviour.PACK_ROAMING),
    SOLO_ROAMER(Behaviour.SOLO_ROAMING),
    NON_ROAMER(Behaviour.NON_ROAMING);

    private final Behaviour behaviour;
    private static final String ROAMING = "I'm roaming ";

    private ConcreteRoamer(final Behaviour behaviour) {
        this.behaviour = behaviour;
    }

    @Override
    public void roam() {
        switch (this) {
            case NON_ROAMER:
                System.out.println(behaviour);
                break;
            default:
                System.out.println(ROAMING + behaviour);
                break;
        }
    }

    private enum Behaviour {
        PACK_ROAMING() {
            @Override
            public String toString() {
                return "in my pack!";
            }
        },
        SOLO_ROAMING() {
            @Override
            public String toString() {
                return "alone.";
            }
        },
        NON_ROAMING() {
            @Override
            public String toString() {
                return "I'm lazy: not roaming.";
            }
        };
    }
}
