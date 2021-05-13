package com.flechow.webcalculator.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public final class CalculatorService {

    public BigDecimal add(final BigDecimal addend, final BigDecimal augend) {
        return addend.add(augend);
    }

    public BigDecimal subtract(final BigDecimal minuend, final BigDecimal subtrahend) {
        return minuend.subtract(subtrahend);
    }

    public BigDecimal multiply(final BigDecimal multiplier, final BigDecimal multiplicand) {
        return multiplier.multiply(multiplicand);
    }

    public BigDecimal divide(final BigDecimal dividend, final BigDecimal divisor) {
        if(divisor.compareTo(BigDecimal.valueOf(0)) == 0) {throw new IllegalArgumentException("Cannot divide by 0");}
        return dividend.divide(divisor);
    }
}