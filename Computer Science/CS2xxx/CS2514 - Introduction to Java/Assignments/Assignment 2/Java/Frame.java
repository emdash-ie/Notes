/**
 * A frame for a Bike.
 *
 * @author Noel Bourke (112493412)
 */
public abstract class Frame extends Component {
    private static final String FRAME_DESCRIPTION = "a frame of type ";

    /**
     * Creates a frame component with a description according to its type.
     *
     * @param type A description of the type of the frame.
     */
    public Frame(final String type) {
        super(FRAME_DESCRIPTION + type);
    }
}
