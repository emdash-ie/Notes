public final class ConcreteCanine implements Canine {
    private final Animal animal;

    public ConcreteCanine(final NoiseMaker noiseMaker) {
        animal = new ConcreteAnimal(ConcreteEater.MEAT_EATER, noiseMaker,
            ConcreteRoamer.PACK_ROAMER);
    }

    @Override
    public void eat() {
        animal.eat();
    }

    @Override
    public void makeNoise() {
        animal.makeNoise();
    }

    @Override
    public void roam() {
        animal.roam();
    }
}
