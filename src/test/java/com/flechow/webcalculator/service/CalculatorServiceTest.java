package com.flechow.webcalculator.service;

import com.flechow.webcalculator.repository.OperationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertThrows;

class CalculatorServiceTest {


    private CalculatorService calculatorService;
    private OperationRepository operationRepository;

    @BeforeEach
    void initService() {
        operationRepository = mock(OperationRepository.class);
        calculatorService = new CalculatorService(operationRepository);
    }

    @Test
    void Should_Add_Integers() {

        //given
        BigDecimal expectedResult = BigDecimal.valueOf(225);
        List<BigDecimal> integers = getListOfIntegers();

        //when
        BigDecimal actualResult = calculatorService.add(integers);

        //than
        assertEquals(expectedResult.compareTo(actualResult), 0);
    }

    @Test
    void Should_Add_Fractions() {

        //given
        BigDecimal expectedResult = BigDecimal.valueOf(29.92);
        List<BigDecimal> fractions = getListOfFractions();


        //when
        BigDecimal actualResult = calculatorService.add(fractions);

        //than
        assertEquals(expectedResult.compareTo(actualResult), 0);
    }

    @Test
    void Should_Add_Zero_And_Fractions() {

        //given
        BigDecimal expectedResult = BigDecimal.valueOf(29.92);
        List<BigDecimal> fractions = getListOfFractionsAndZero();

        //when
        BigDecimal actualResult = calculatorService.add(fractions);

        //than
        assertEquals(expectedResult.compareTo(actualResult), 0);
    }

    @Test
    void Should_Subtract_Integers() {

        //given
        BigDecimal expectedResult = BigDecimal.valueOf(-185);
        List<BigDecimal> integers = getListOfIntegers();

        //when
        BigDecimal actualResult = calculatorService.subtract(integers);

        //than
        assertEquals(expectedResult.compareTo(actualResult), 0);
    }

    @Test
    void Should_Subtract_Fractions() {

        //given
        BigDecimal expectedResult = BigDecimal.valueOf(-15.66);
        List<BigDecimal> fractions = getListOfFractions();

        //when
        BigDecimal actualResult = calculatorService.subtract(fractions);

        //than
        assertEquals(expectedResult.compareTo(actualResult), 0);
    }

    @Test
    void Should_Subtract_Fractions_And_Zero() {

        //given
        BigDecimal expectedResult = BigDecimal.valueOf(-15.66);
        List<BigDecimal> fractions = getListOfFractionsAndZero();

        //when
        BigDecimal actualResult = calculatorService.subtract(fractions);

        //than
        assertEquals(expectedResult.compareTo(actualResult), 0);
    }

    @Test
    void Should_Multiply_Integers() {

        //given
        BigDecimal expectedResult = BigDecimal.valueOf(960000);
        List<BigDecimal> integers = getListOfIntegers();

        //when
        BigDecimal actualResult = calculatorService.multiply(integers);

        //than
        assertEquals(expectedResult.compareTo(actualResult), 0);
    }

    @Test
    void Should_Multiply_Fractions() {

        //given
        BigDecimal expectedResult = BigDecimal.valueOf(771.24800025);
        List<BigDecimal> fractions = getListOfFractions();

        //when
        BigDecimal actualResult = calculatorService.multiply(fractions);

        //than
        assertEquals(expectedResult.compareTo(actualResult), 0);
    }

    @Test
    void Should_Multiply_Fractions_And_Zero() {

        //given
        BigDecimal expectedResult = BigDecimal.ZERO;
        List<BigDecimal> fractions = getListOfFractionsAndZero();

        //when
        BigDecimal actualResult = calculatorService.multiply(fractions);

        //than
        assertEquals(expectedResult.compareTo(actualResult), 0);
    }


    @Test
    void Should_Divide_Integers() {

        //given
        BigDecimal expectedResult = BigDecimal.valueOf(0.000416666666667);
        List<BigDecimal> integers = getListOfIntegers();

        //when
        BigDecimal actualResult = calculatorService.divide(integers);

        //than
        assertEquals(expectedResult.compareTo(actualResult), 0);
    }

    @Test
    void Should_Divide_Fractions() {

        //given
        BigDecimal expectedResult = BigDecimal.valueOf(0.065915114183144);
        List<BigDecimal> fractions = getListOfFractions();

        //when
        BigDecimal actualResult = calculatorService.divide(fractions);

        //than
        assertEquals(expectedResult.compareTo(actualResult), 0);
    }

    @Test
    void Should_Throw_IllegalArhimentException_When_Divide_By_Zero() {

        //given
        List<BigDecimal> fractions = getListOfFractionsAndZero();

        //when & than
        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(fractions));
    }

    private List<BigDecimal> getListOfIntegers() {
        BigDecimal num1 = BigDecimal.valueOf(20);
        BigDecimal num2 = BigDecimal.valueOf(80);
        BigDecimal num3 = BigDecimal.valueOf(120);
        BigDecimal num4 = BigDecimal.valueOf(5);
        List<BigDecimal> integers = List.of(num1, num2, num3, num4);
        return integers;
    }

    private List<BigDecimal> getListOfIntegersAndZero() {
        BigDecimal num1 = BigDecimal.valueOf(20);
        BigDecimal num2 = BigDecimal.valueOf(80);
        BigDecimal num3 = BigDecimal.valueOf(120);
        BigDecimal num4 = BigDecimal.valueOf(5);
        BigDecimal num5 = BigDecimal.ZERO;
        List<BigDecimal> integersWithZero = List.of(num1, num2, num3, num4, num5);
        return integersWithZero;
    }

    private List<BigDecimal> getListOfFractions() {
        BigDecimal num1 = BigDecimal.valueOf(7.13);
        BigDecimal num2 = BigDecimal.valueOf(5.87);
        BigDecimal num3 = BigDecimal.valueOf(1.17);
        BigDecimal num4 = BigDecimal.valueOf(15.75);
        List<BigDecimal> fractions = List.of(num1, num2, num3, num4);
        return fractions;
    }

    private List<BigDecimal> getListOfFractionsAndZero() {
        BigDecimal num1 = BigDecimal.valueOf(7.13);
        BigDecimal num2 = BigDecimal.valueOf(5.87);
        BigDecimal num3 = BigDecimal.valueOf(1.17);
        BigDecimal num4 = BigDecimal.valueOf(15.75);
        BigDecimal num5 = BigDecimal.ZERO;
        List<BigDecimal> fractionsWithZero = List.of(num1, num2, num3, num4, num5);
        return fractionsWithZero;
    }
}