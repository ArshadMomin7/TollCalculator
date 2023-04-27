import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TollCalculatorTest {

    @Test
    void testCalculateToll() {
        TollCalculator calculator = new TollCalculator();
        double expectedToll = 2.25;
        double actualToll = calculator.calculateToll("Toronto", "Mississauga");
        assertEquals(expectedToll, actualToll);
    }

    @Test
    void testCalculateTollNegativeDistance() {
        TollCalculator calculator = new TollCalculator();
        double expectedToll = -1;
        double actualToll = calculator.calculateToll("Mississauga", "Toronto");
        assertEquals(expectedToll, actualToll);
    }

    @Test
    void testCalculateTollSamePoint() {
        TollCalculator calculator = new TollCalculator();
        double expectedToll = 0;
        double actualToll = calculator.calculateToll("Toronto", "Toronto");
        assertEquals(expectedToll, actualToll);
    }

}