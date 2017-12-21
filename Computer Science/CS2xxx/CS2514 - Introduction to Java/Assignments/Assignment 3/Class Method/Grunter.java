public final class Grunter implements NoiseMaker {
    private static final String NOISE = "Grunt.";

    @Override
    public void makeNoise() {
        System.out.println(NOISE);
    }
}
