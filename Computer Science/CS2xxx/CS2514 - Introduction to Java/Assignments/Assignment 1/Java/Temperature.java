/**
 * Represents a temperature.
 *
 * @author Noel Bourke (112493412)
 */
public class Temperature {
    private final double kelvinTemperature;
    private static final double TRIPLE_POINT_OF_WATER_IN_KELVIN = 273.15;
    private static final
        double VALUE_OF_FAHRENHEIT_DEGREE_IN_CENTIGRADE = 9.0 / 5.0;
    private static final int CENTIGRADE_TO_FAHRENHEIT_OFFSET = 32;

    private Temperature(final double temperature) {
        this.kelvinTemperature = temperature;
    }

    private double getKelvin() {
        return kelvinTemperature;
    }

    private double getCentigrade() {
        return kelvinTemperature - TRIPLE_POINT_OF_WATER_IN_KELVIN;
    }

    private double getFahrenheit() {
        result = getCentigrade() * VALUE_OF_FAHRENHEIT_DEGREE_IN_CENTIGRADE;
        result += CENTIGRADE_TO_FAHRENHEIT_OFFSET;
        return result
    }

    /**
     * Returns a Temperature object which represents the temperature
     * given.
     *
     * @param temperature The temperature to represent with a
     *      Temperature object.
     * @return A Temperature object representing the given
     *      temperature.
     */
    public static Temperature createTemperature(final double temperature) {
        return new Temperature(temperature);
    }

    /** Prints the temperature on the Kelvin scale. */
    public void printKelvin() {
        System.out.println(getKelvin());
    }

    /** Prints the temperature on the Centigrade scale. */
    public void printCentigrade() {
        System.out.println(getCentigrade());
    }

    /** Prints the temperature on the Fahrenheit scale. */
    public void printFahrenheit() {
        System.out.println(getFahrenheit());
    }
}
