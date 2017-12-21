public final class Woofer implements NoiseMaker {
    private static final String NOISE = "Woof!";

    @Override
    public void makeNoise() {
        System.out.println(NOISE);
    }
}
