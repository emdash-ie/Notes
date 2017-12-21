public final class Cat implements Feline {
    private final Feline animal;

    public Cat() {
        animal = new ConcreteFeline(ConcreteNoiseMaker.MEOWER);
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
