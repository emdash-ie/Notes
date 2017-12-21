// Component should be an abstract class
/**
 * A Bike component.
 *
 * @author Noel Bourke (112493412)
 */
public abstract class Component {
    private final String description;

    /**
     * Creates a component with the given description.
     *
     * @param description A description of the component.
     */
    public Component(final String description) {
        this.description = description;
    }

    // toString is overriding a method in the Object class, so use Override
    // flag to prevent errors
    /**
     * Uses the description of the component as its String representation.
     *
     * @return A String description of the component.
     */
    @Override
    public String toString() {
        return description;
    }
}
