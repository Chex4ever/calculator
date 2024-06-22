package pro.sky.exever.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {

    private final  CalculatorService calculatorService = new CalculatorServiceImpl();

    @Test
    void plus() {
        assertEquals(7, calculatorService.plus(3d,4d));
        assertEquals(-4.5, calculatorService.plus(0d,-4.5d));
    }

    @Test
    void minus() {
        assertEquals(1, calculatorService.minus(4d,3d));
        assertEquals(0, calculatorService.minus(-4d,-4d));
    }

    @Test
    void multiply() {
        assertEquals(1.5, calculatorService.multiply(.5d,3d));
        assertEquals(0, calculatorService.multiply(1d,0d));
    }

    @Test
    void divide() {
        assertEquals(0.5, calculatorService.divide(1.5d,3d));
        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(1d,0d));
    }
}