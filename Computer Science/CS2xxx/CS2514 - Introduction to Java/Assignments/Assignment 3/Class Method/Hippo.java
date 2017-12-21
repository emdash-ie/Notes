public final class Hippo implements Animal {
    private final Animal animal;

    public Hippo() {
        animal = new ConcreteAnimal(new GrassEater(), new Grunter(),
            new NonRoamer());
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
