/**
 * A Bike with lights.
 *
 * @author Noel Bourke (112493412)
 */
public abstract class BikeWithLights extends Bike {
    // variable names and class names should be readable
    private FrontLight frontLight;
    private RearLight rearLight;
    /**
     * Gives the bike a FrontLight and a RearLight.
     *
     * @param frame A Frame for the Bike.
     */
    public BikeWithLights(Frame frame) {
        super(frame);
        frontLight = new FrontLight();
        rearLight = new RearLight();
    }
    /**
     * Prints the front light and rear light components, and then calls
     * the superclass' method to print the rest of the components.
     */
    public void printComponents() {
        System.out.print(frontLight + getSeparator());
        System.out.print(rearLight + getSeparator());
        // call superclass' method
        super.printComponents();
    }
}
