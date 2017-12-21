public final class ConcreteAnimal implements Animal {
    private final Eater eater;
    private final NoiseMaker noiseMaker;
    private final Roamer roamer;

    public ConcreteAnimal(final Eater eater, final NoiseMaker noiseMaker,
        final Roamer roamer) {
        this.eater = eater;
        this.noiseMaker = noiseMaker;
        this.roamer = roamer;
    }

    @Override
    public void eat() {
        eater.eat();
    }

    @Override
    public void makeNoise() {
        noiseMaker.makeNoise();
    }

    @Override
    public void roam() {
        roamer.roam();
    }
}
