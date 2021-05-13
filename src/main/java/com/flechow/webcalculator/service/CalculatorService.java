package com.flechow.webcalculator.service;

import com.flechow.webcalculator.enums.ArithmeticOperation;
import com.flechow.webcalculator.model.Operation;
import com.flechow.webcalculator.repository.OperationRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

import static com.flechow.webcalculator.enums.ArithmeticOperation.*;

@Service
public final class CalculatorService {

    final private OperationRepository operationRepository;

    CalculatorService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public BigDecimal add(final List<BigDecimal> numbers) {
        BigDecimal result = numbers.stream().reduce(BigDecimal::add).get();
        Operation operation = createOperation(ADD, result);
        operationRepository.save(operation);
        return result;
    }

    public BigDecimal subtract(final List<BigDecimal> numbers) {
        BigDecimal result = numbers.stream().reduce(BigDecimal::subtract).get();
        Operation operation = createOperation(SUBTRACT, result);
        operationRepository.save(operation);
        return result;
    }

    public BigDecimal multiply(final List<BigDecimal> numbers) {
        BigDecimal result = numbers.stream().reduce(BigDecimal::multiply).get();
        Operation operation = createOperation(MULTIPLY, result);
        operationRepository.save(operation);
        return result;
    }

    public BigDecimal divide(final List<BigDecimal> numbers) {
        if (containsEqualToZero(numbers)) {
            throw new IllegalArgumentException("Cannot divide by 0");
        }
        BigDecimal result = numbers.stream().reduce((dividend, divisor) -> dividend.divide(divisor, 15, RoundingMode.CEILING)).get();
        Operation operation = createOperation(DIVIDE, result);
        operationRepository.save(operation);
        return result;
    }

    private boolean containsEqualToZero(List<BigDecimal> numbers) {
        return numbers.stream().anyMatch(number -> number.compareTo(BigDecimal.ZERO) == 0);
    }

    private Operation createOperation(ArithmeticOperation operation, BigDecimal result) {
        return Operation.builder()
                .name(operation.getName())
                .result(result)
                .timestamp(LocalDateTime.now())
                .build();
    }
}
