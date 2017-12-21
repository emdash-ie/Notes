/**
 * Test class for assignment 2.
 *
 * @author Noel Bourke (112493412)
 */
public class Main {
    /**
     * Creates a MountainBike, a CityBike, and a Hybrid, and prints
     * their components.
     */
    public static void main(String[] args) {
        Bike myBike = new MountainBike();
        Bike yourBike = new CityBike();
        Bike herBike = new Hybrid();

        System.out.print("My bike is a MountainBike, and has: ");
        myBike.printComponents();
        System.out.println();

        System.out.print("Your bike is a CityBike, and has: ");
        yourBike.printComponents();
        System.out.println();

        System.out.print("Her bike is a Hybrid, and has: ");
        herBike.printComponents();
        System.out.println();
    }
}
