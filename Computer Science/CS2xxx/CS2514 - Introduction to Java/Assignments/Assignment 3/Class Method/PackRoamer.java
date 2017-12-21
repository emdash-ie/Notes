public final class PackRoamer implements Roamer {
    private static final String ROAMING_BEHAVIOUR = "I'm roaming in my pack!";

    @Override
    public void roam() {
        System.out.println(ROAMING_BEHAVIOUR);
    }
}
