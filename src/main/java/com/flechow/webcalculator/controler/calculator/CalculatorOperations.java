package com.flechow.webcalculator.controler.calculator;

import com.flechow.webcalculator.model.InputData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.math.BigDecimal;

@RequestMapping("calculate/")
public interface CalculatorOperations {

    @PostMapping("add")
    BigDecimal add(@Valid @RequestBody InputData inputData);

    @PostMapping("subtract")
    BigDecimal subtract(@Valid @RequestBody InputData inputData);

    @PostMapping("multiply")
    BigDecimal multiply(@Valid @RequestBody InputData inputData);

    @PostMapping("divide")
    BigDecimal divide(@Valid @RequestBody InputData inputData);

}
