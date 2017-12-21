# Temperature.java

```java
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
```

* constants used in place of literal values

    * constants named descriptively

* attribute is private

* constructor is private

    * value-checking on the temperature value can be done in the public `createTemperature` method

# Main.java

```java
/**
 * Tests the Temperature class.
 *
 * @author Noel Bourke (112493412)
 */
public class Main {
    /**
     * Tests the Temperature class with three temperatures.
     */
    public static void main(String[] args) {
        System.out.println("First Temperature:");
        temperatureTest(273.15);

        System.out.println("\nSecond Temperature:");
        temperatureTest(373.15);

        System.out.println("\nThird Temperature:");
        temperatureTest(233.15);
    }
    /**
     * Creates a Temperature and prints its value in Kelvin, Centigrade,
     * and Fahrenheit.
     *
     * @param temperature The temperature value to test with, in Kelvin.
     */
    public static void temperatureTest(Double temperature) {
        final Temperature testTemperature
                = Temperature.createTemperature(temperature);
        System.out.println("Kelvin:");
        testTemperature.printKelvin();
        System.out.println("Centigrade:");
        testTemperature.printCentigrade();
        System.out.println("Fahrenheit:");
        testTemperature.printFahrenheit();
    }
}
```
