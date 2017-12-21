/**
 * A bike.
 *
 * @author Noel Bourke (112493412)
 */
public abstract class Bike {
    private final Brakes brakes;
    private final Wheels wheels;
    private final Saddle saddle;
    private final Handlebar handlebar;
    private final Frame frame;
    /** Used to separate Components when printing. */
    private static final String SEPARATOR = ", ";
    /** Used to finish a list of Components when printing. */
    private static final String TERMINATOR = ".";
    /**
     * Gives this bike four Components: Brakes, Wheels, a Saddle, and a
     * Handlebar.
     *
     * @param frame A Frame for this bike.
     */
    public Bike(final Frame frame) {
        brakes = new Brakes();
        wheels = new Wheels();
        saddle = new Saddle();
        handlebar = new Handlebar();
        this.frame = frame;
    }

    public String getSeparator() {
        return SEPARATOR;
    }

    public String getTerminator() {
        return TERMINATOR;
    }

    /**
     * Prints the components of this bike that are defined in this
     * class.
     */
    public void printComponents() {
        System.out.print(frame + getSeparator());
        System.out.print(brakes + getSeparator());
        System.out.print(wheels + getSeparator());
        System.out.print(saddle + getSeparator());
        System.out.print(handlebar + getTerminator());
    }
}
