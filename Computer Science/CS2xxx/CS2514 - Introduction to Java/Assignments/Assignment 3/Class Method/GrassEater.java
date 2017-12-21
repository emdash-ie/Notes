public final class GrassEater implements Eater {
    private static final String EATING_BEHAVIOUR = "I'm eating grass.";

    @Override
    public void eat() {
        System.out.println(EATING_BEHAVIOUR);
    }
}
