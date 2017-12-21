public final class ConcreteFeline implements Feline {
    private final Animal animal;

    public ConcreteFeline(final NoiseMaker noiseMaker) {
        animal = new ConcreteAnimal(ConcreteEater.MEAT_EATER, noiseMaker,
            ConcreteRoamer.SOLO_ROAMER);
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
