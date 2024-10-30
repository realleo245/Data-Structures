package Calculator.Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Calculator.NumCalc;

public class NumCalcTest {
    @Test
    public void evaluateTest() {
        NumCalc calculator = new NumCalc();
        assertEquals("3.0", calculator.evaluate("1 + 2"));
        assertEquals("4.0", calculator.evaluate("2 * 2"));
        assertEquals("3.0", calculator.evaluate("1 + 1 + 1"));
        assertEquals("43.0", calculator.evaluate("2 ^ 3 + 5 * 7"));
    }
}
