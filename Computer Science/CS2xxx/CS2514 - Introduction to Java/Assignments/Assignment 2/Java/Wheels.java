// Class is final because it (arguably) shouldn't be extended further
/**
 * Wheels for a Bike.
 *
 * @author Noel Bourke (112493412)
 */
public final class Wheels extends Component {
    // Would be better to use enumerated types, but we hadn't studied them yet
    private static final String WHEELS_DESCRIPTION = "wheels";

    /**
     * Creates a wheels component with a default description.
     */
    public Wheels() {
        super(WHEELS_DESCRIPTION);
    }
}
