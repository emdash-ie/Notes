public final class Meower implements NoiseMaker {
    private static final String NOISE = "Meow.";

    @Override
    public void makeNoise() {
        System.out.println(NOISE);
    }
}
