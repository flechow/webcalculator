package com.flechow.webcalculator.controler;

import com.flechow.webcalculator.model.Input;
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
    public BigDecimal add(Input input) {
        log.info("Add numbers {} and {}", input.getDecimalOne(), input.getDecimalTwo());
        return calculatorService.add(input.getDecimalOne(), input.getDecimalTwo());
    }

    @Override
    public BigDecimal subtract(Input input) {
        log.info("Subtract numbers {} and {}", input.getDecimalOne(), input.getDecimalTwo());
        return calculatorService.subtract(input.getDecimalOne(), input.getDecimalTwo());
    }

    @Override
    public BigDecimal multiply(Input input) {
        log.info("Multiply numbers {} and {}", input.getDecimalOne(), input.getDecimalTwo());
        return calculatorService.multiply(input.getDecimalOne(), input.getDecimalTwo());
    }

    @Override
    public BigDecimal divide(Input input) {
        log.info("Divide {} by {}", input.getDecimalOne(), input.getDecimalTwo());
        return calculatorService.divide(input.getDecimalOne(), input.getDecimalTwo());
    }
}
