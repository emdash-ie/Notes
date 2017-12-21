# Info

* For the general class structure, we create interfaces for each top and middle level, and create concrete classes which implement those interfaces

    * Instead of each level inheriting from the one above it, each level contains an object from the level above, which it delegates the methods to

        * So a Dog object contains a ConcreteCanine object which contains a ConcreteAnimal object.

    * Shared canine behaviour can be put in the ConcreteCanine class and shared animal behaviour in the ConcreteAnimal class

    * Dog implements the Canine interface so that you can use a variable of type `Canine` to hold a Dog object or an object of another class that implements Canine

    * It does bug me a bit that Dog implements Canine and also has an animal attribute that implements Canine – seems like the Canine interface (along with the Eater, NoiseMaker, and Roamer interfaces) is being used for more than one thing and it makes me uncomfortable.

* For enum method and class method, see relevant folders.

* For animal noises, since it's unlikely any class is going to share a noise, it may also make sense to use anonymous classes like this:

    * for each animal, make an anonymous class that implements the `NoiseMaker` interface

```java
public final class Dog implements Canine {
    private static final String WOOF = "Woof!";
    private final Canine animal;

    public Dog() {
        final NoiseMaker noiseMaker = new NoiseMaker() {
            @Override
            public void makeNoise() {
                System.out.println(WOOF);
            }
        };
        animal = new ConcreteCanine(noiseMaker);
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
```
