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
