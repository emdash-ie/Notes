public enum ConcreteEater implements Eater {
    MEAT_EATER(Food.MEAT),
    GRASS_EATER(Food.GRASS);

    private final Food food;

    private ConcreteEater(final Food food) {
        this.food = food;
    }

    @Override
    public void eat() {
        System.out.println("I'm eating " + food + ".");
    }

    private enum Food {
        MEAT() {
            @Override
            public String toString() {
                return "meat";
            }
        },
        GRASS() {
            @Override
            public String toString() {
                return "grass";
            }
        };
    }
}
