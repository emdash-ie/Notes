public enum ConcreteNoiseMaker implements NoiseMaker {
    WOOFER(AnimalNoise.WOOF),
    MEOWER(AnimalNoise.MEOW),
    GRUNTER(AnimalNoise.GRUNT);

    private final AnimalNoise noise;

    private ConcreteNoiseMaker(final AnimalNoise noise) {
        this.noise = noise;
    }

    @Override
    public void makeNoise() {
        System.out.println(noise);
    }

    private enum AnimalNoise {
        WOOF() {
            @Override
            public String toString() {
                return "Woof!";
            }
        },
        MEOW() {
            @Override
            public String toString() {
                return "Meow.";
            }
        },
        GRUNT() {
            @Override
            public String toString() {
                return "Grunt.";
            }
        };
    }
}
