import com.korotkov.dockertest.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {
    private Calculator calculator;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testPlus() {
        String input = "5\n3\n+\n\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        calculator.calculate();
        String output = outputStream.toString();
        assertTrue(output.contains("8"));
    }

    @Test
    void testMinus() {
        String input = "5\n3\n-\n\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        calculator.calculate();
        String output = outputStream.toString();
        assertTrue(output.contains("2"));
    }

    @Test
    void testDivision() {
        String input = "6\n3\n/\n\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        calculator.calculate();
        String output = outputStream.toString();
        assertTrue(output.contains("2"));
    }

    @Test
    void testMultiplication() {
        String input = "5\n3\n*\n\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        calculator.calculate();
        String output = outputStream.toString();
        assertTrue(output.contains("15"));
    }


    @Test
    void testInvalidNumberInput() {
        String input = "invalid\n5\n3\n+\n\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        calculator.calculate();

        String output = outputStream.toString();
        assertTrue(output.contains("Please enter a valid number!"));
    }

    @Test
    void testInvalidOperationInput() {
        String input = "5\n3\nx\n+\n\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        calculator.calculate();

        String output = outputStream.toString();
        assertTrue(output.contains("Please enter a valid operation!"));
    }
}

