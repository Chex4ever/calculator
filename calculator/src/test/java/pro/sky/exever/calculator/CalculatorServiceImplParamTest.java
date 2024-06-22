package pro.sky.exever.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplParamTest {

    private final CalculatorService calculatorService = new CalculatorServiceImpl();

    @ParameterizedTest
    @MethodSource("provideParamsForSum")
    void plus(Double a, Double b, Double expected) {
        assertEquals(expected, calculatorService.plus(a, b));
    }
    static Stream<Arguments> provideParamsForSum() {
        return Stream.of(
                Arguments.of(5d, 5d, 10d),
                Arguments.of(0d, 0d, 0d),
                Arguments.of(-3d, -4d, -7d));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMinus")
    void minus(Double a, Double b, Double expected) {
        assertEquals(expected, calculatorService.minus(a, b));
    }
    static Stream<Arguments> provideParamsForMinus() {
        return Stream.of(
                Arguments.of(5d, 5d, 0d),
                Arguments.of(0d, 0d, 0d),
                Arguments.of(-3d, -4d, 1d));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMultiply")
    void multiply(Double a, Double b, Double expected) {
        assertEquals(expected, calculatorService.multiply(a, b));
    }
    static Stream<Arguments> provideParamsForMultiply() {
        return Stream.of(
                Arguments.of(5d, 5d, 25d),
                Arguments.of(0d, 0d, 0d),
                Arguments.of(-3d, -4d, 12d));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForDivide")
    void divide(Double a, Double b, Double expected) {
        assertEquals(expected, calculatorService.divide(a, b));
    }
    static Stream<Arguments> provideParamsForDivide() {
        return Stream.of(
                Arguments.of(5d, 5d, 1d),
                Arguments.of(-3d, 6d, -0.5d));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForDivideOnZero")
    void divideOnZero(Double a, Double b) {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(a, b));
    }
    static Stream<Arguments> provideParamsForDivideOnZero() {
        return Stream.of(
                Arguments.of(3d, 0d),
                Arguments.of(-3d, 0d));
    }
}
