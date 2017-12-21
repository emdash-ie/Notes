public final class MeatEater implements Eater {
    private static final String EATING_BEHAVIOUR = "I'm eating meat.";

    @Override
    public void eat() {
        System.out.println(EATING_BEHAVIOUR);
    }
}
