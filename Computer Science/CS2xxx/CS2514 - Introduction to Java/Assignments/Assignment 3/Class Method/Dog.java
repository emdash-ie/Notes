public final class Dog implements Canine {
    private final Canine animal;

    public Dog() {
        animal = new ConcreteCanine(new Woofer());
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
