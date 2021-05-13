package com.flechow.webcalculator.controler.calculator;

import com.flechow.webcalculator.model.InputData;
import com.flechow.webcalculator.service.CalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Slf4j
@RestController
public class CalculatorController implements CalculatorOperations {

    private final CalculatorService calculatorService;

    CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @Override
    public BigDecimal add(InputData inputData) {
        log.info("Add numbers {}", inputData.getNumbers());
        return calculatorService.add(inputData.getNumbers());
    }

    @Override
    public BigDecimal subtract(InputData inputData) {
        log.info("Subtract numbers {}", inputData.getNumbers());
        return calculatorService.subtract(inputData.getNumbers());
    }

    @Override
    public BigDecimal multiply(InputData inputData) {
        log.info("Multiply numbers {} ", inputData.getNumbers());
        return calculatorService.multiply(inputData.getNumbers());

    }

    @Override
    public BigDecimal divide(InputData inputData) {
        log.info("Divide {}",inputData.getNumbers());
        return calculatorService.divide(inputData.getNumbers());

    }
}
