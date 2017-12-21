public final class ConcreteFeline implements Feline {
    private final Animal animal;

    public ConcreteFeline(final NoiseMaker noiseMaker) {
        animal = new ConcreteAnimal(new MeatEater(), noiseMaker, new SoloRoamer());
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
