public final class SoloRoamer implements Roamer {
    private static final String ROAMING_BEHAVIOUR = "I'm roaming alone.";

    @Override
    public void roam() {
        System.out.println(ROAMING_BEHAVIOUR);
    }
}
