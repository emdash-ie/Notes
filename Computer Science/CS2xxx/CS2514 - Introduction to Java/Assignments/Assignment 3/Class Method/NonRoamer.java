public final class NonRoamer implements Roamer {
    private static final String ROAMING_BEHAVIOUR = "I'm lazy: not roaming.";

    @Override
    public void roam() {
        System.out.println(ROAMING_BEHAVIOUR);
    }
}
