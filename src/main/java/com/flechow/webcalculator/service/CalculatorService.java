package com.flechow.webcalculator.service;

import com.flechow.webcalculator.enums.ArithmeticOperation;
import com.flechow.webcalculator.model.Operation;
import com.flechow.webcalculator.repository.OperationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

import static com.flechow.webcalculator.enums.ArithmeticOperation.*;

@Slf4j
@Service
public final class CalculatorService {

    final private OperationRepository operationRepository;

    CalculatorService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public BigDecimal add(final BigDecimal addend, final BigDecimal augend) {
        BigDecimal result = addend.add(augend);
        Operation operation = createRequest(addend, augend, ADD, result);
        operationRepository.save(operation);
        return result;
    }

    public BigDecimal subtract(final BigDecimal minuend, final BigDecimal subtrahend) {
        BigDecimal result =  minuend.subtract(subtrahend);
        Operation operation = createRequest(minuend, subtrahend, SUBTRACT, result);
        operationRepository.save(operation);
        return result;
    }

    public BigDecimal multiply(final BigDecimal multiplier, final BigDecimal multiplicand) {
        BigDecimal result =  multiplier.multiply(multiplicand);
        Operation operation = createRequest(multiplier, multiplicand, MULTIPLY, result);
        operationRepository.save(operation);
        return result;
    }

    public BigDecimal divide(final BigDecimal dividend, final BigDecimal divisor) {
        if (divisor.compareTo(BigDecimal.valueOf(0)) == 0) {
            throw new IllegalArgumentException("Cannot divide by 0");
        }
            BigDecimal result =  dividend.divide(divisor, 15, RoundingMode.CEILING);
            Operation operation = createRequest(dividend, divisor, DIVIDE, result);
            operationRepository.save(operation);
            return result;
    }

    private Operation createRequest(BigDecimal num1, BigDecimal num2, ArithmeticOperation operation, BigDecimal result) {
        return Operation.builder()
                .num1(num1)
                .num2(num2)
                .name(operation.getName())
                .result(result)
                .timestamp(LocalDateTime.now())
                .build();
    }
}
