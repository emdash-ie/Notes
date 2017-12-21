public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Hippo hippo = new Hippo();

        dog.eat();
        dog.roam();
        dog.makeNoise();

        cat.eat();
        cat.roam();
        cat.makeNoise();

        hippo.eat();
        hippo.roam();
        hippo.makeNoise();
    }
}
