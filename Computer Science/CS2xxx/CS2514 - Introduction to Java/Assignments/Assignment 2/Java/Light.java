/**
 * A light for a Bike.
 *
 * @author Noel Bourke (112493412)
 */
public abstract class Light extends Component {
    private static final String BRIGHT = "a bright ";

    /**
     * Creates a light component with a description according to its type.
     *
     * @param type A description of the type of the light.
     */
    public Light(final String type) {
        super(BRIGHT + type);
    }
}
