/**
 * A city bike.
 *
 * @author Noel Bourke (112493412)
 */
public class CityBike extends BikeWithLights {
    private Carrier carrier;
    /**
     * Gives the bike a Carrier and a HighFrame.
     */
    public CityBike() {
        super(new HighFrame());
        carrier = new Carrier();
    }
    /**
     * Prints the carrier component of this bike, and calls the
     * superclass' method to print the rest of the components.
     */
    @Override
    public void printComponents() {
        System.out.print(carrier + getSeparator());
        super.printComponents();
    }
}
