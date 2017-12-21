public final class Hippo implements Animal {
    private final Animal animal;

    public Hippo() {
        animal = new ConcreteAnimal(ConcreteEater.GRASS_EATER,
            ConcreteNoiseMaker.GRUNTER, ConcreteRoamer.NON_ROAMER);
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
