package com.flechow.webcalculator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorServiceTest {

    private CalculatorService calculator;

    @BeforeEach
    public void setUp() {
        calculator = new CalculatorService();
    }

    @Test
    @DisplayName("Should add integers")
    void simpleAddition() {

        //given
        BigDecimal expectedResult = BigDecimal.valueOf(100);
        BigDecimal num1 = BigDecimal.valueOf(20);
        BigDecimal num2 = BigDecimal.valueOf(80);

        //when
        BigDecimal actualResult = calculator.add(num1, num2);

        //than
        assertEquals(expectedResult.compareTo(actualResult), 0);
    }

    @Test
    @DisplayName("Should add fractions")
    void fractionAddition() {

        //given
        BigDecimal expectedResult = BigDecimal.valueOf(13.00);
        BigDecimal num1 = BigDecimal.valueOf(7.13);
        BigDecimal num2 = BigDecimal.valueOf(5.87);

        //when
        BigDecimal actualResult = calculator.add(num1, num2);

        //than
        assertEquals(expectedResult.compareTo(actualResult), 0);
    }

    @Test
    @DisplayName("Should add zero and fraction")
    void zeroAddition() {

        //given
        BigDecimal expectedResult = BigDecimal.valueOf(7.13);
        BigDecimal num1 = BigDecimal.valueOf(7.13);
        BigDecimal num2 = BigDecimal.valueOf(0);

        //when
        BigDecimal actualResult = calculator.add(num1, num2);

        //than
        assertEquals(expectedResult.compareTo(actualResult), 0);
    }

    @Test
    @DisplayName("Should subtract integers")
    void simpleSubtraction() {

        //given
        BigDecimal expectedResult = BigDecimal.valueOf(14);
        BigDecimal num1 = BigDecimal.valueOf(20);
        BigDecimal num2 = BigDecimal.valueOf(6);

        //when
        BigDecimal actualResult = calculator.subtract(num1, num2);

        //than
        assertEquals(expectedResult.compareTo(actualResult), 0);
    }

    @Test
    @DisplayName("Should subtract fractions")
    void fractionSubtraction() {

        //given
        BigDecimal expectedResult = BigDecimal.valueOf(16.123);
        BigDecimal num1 = BigDecimal.valueOf(345.712);
        BigDecimal num2 = BigDecimal.valueOf(329.589);

        //when
        BigDecimal actualResult = calculator.subtract(num1, num2);

        //than
        assertEquals(expectedResult.compareTo(actualResult), 0);
    }

    @Test
    @DisplayName("Should subtract zero and fraction")
    void zeroSubtraction() {

        //given
        BigDecimal expectedResult = BigDecimal.valueOf(12.87);
        BigDecimal num1 = BigDecimal.valueOf(12.87);
        BigDecimal num2 = BigDecimal.valueOf(0);

        //when
        BigDecimal actualResult = calculator.subtract(num1, num2);

        //than
        assertEquals(expectedResult.compareTo(actualResult), 0);
    }

    @Test
    @DisplayName("Should multiply integers")
    void simpleMultiplication() {

        //given
        BigDecimal expectedResult = BigDecimal.valueOf(150);
        BigDecimal num1 = BigDecimal.valueOf(15.0);
        BigDecimal num2 = BigDecimal.valueOf(10.0);

        //when
        BigDecimal actualResult = calculator.multiply(num1, num2);

        //than
        assertEquals(expectedResult.compareTo(actualResult), 0);
    }

    @Test
    @DisplayName("Should multiply fractions")
    void fractionMultiplication() {

        //given
        BigDecimal expectedResult = BigDecimal.valueOf(768.9001);
        BigDecimal num1 = BigDecimal.valueOf(12.23);
        BigDecimal num2 = BigDecimal.valueOf(62.87);

        //when
        BigDecimal actualResult = calculator.multiply(num1, num2);

        //than
        assertEquals(expectedResult.compareTo(actualResult), 0);
    }

    @Test
    @DisplayName("Should multiply zero and fraction")
    void zeroMultiplication() {

        //given
        BigDecimal expectedResult = BigDecimal.valueOf(0);
        BigDecimal num1 = BigDecimal.valueOf(15.452);
        BigDecimal num2 = BigDecimal.valueOf(0);

        //when
        BigDecimal actualResult = calculator.multiply(num1, num2);

        //than
        assertEquals(expectedResult.compareTo(actualResult), 0);
    }


    @Test
    @DisplayName("Should divide integers")
    void simpleDivision() {

        //given
        BigDecimal expectedResult = BigDecimal.valueOf(12);
        BigDecimal num1 = BigDecimal.valueOf(180);
        BigDecimal num2 = BigDecimal.valueOf(15);

        //when
        BigDecimal actualResult = calculator.divide(num1, num2);

        //than
        assertEquals(expectedResult.compareTo(actualResult), 0);
    }

    @Test
    @DisplayName("Should divide fractions")
    void fractionDivision() {

        //given
        BigDecimal expectedResult = BigDecimal.valueOf(6.17);
        BigDecimal num1 = BigDecimal.valueOf(2.7765);
        BigDecimal num2 = BigDecimal.valueOf(0.45);

        //when
        BigDecimal actualResult = calculator.divide(num1, num2);

        //than
        assertEquals(expectedResult.compareTo(actualResult), 0);
    }

    @Test
    @DisplayName("Should not divide by zero")
    void zeroDivision() {

        //given
        BigDecimal num1 = BigDecimal.valueOf(231);
        BigDecimal num2 = BigDecimal.valueOf(0);

        //when & than
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(num1, num2));
    }

    @Test
    @DisplayName("Should not terminate non-terminating division ")
    void nonTerminatingDivision() {

        //given
        BigDecimal num1 = BigDecimal.valueOf(1);
        BigDecimal num2 = BigDecimal.valueOf(3);

        //when & than
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(num1, num2));
    }
}