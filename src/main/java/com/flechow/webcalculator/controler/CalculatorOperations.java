package com.flechow.webcalculator.controler;

import com.flechow.webcalculator.model.Input;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.math.BigDecimal;

@RequestMapping("calculate/")
public interface CalculatorOperations {

    @PostMapping("add")
    BigDecimal add(@Valid @RequestBody Input input);

    @PostMapping("subtract")
    BigDecimal subtract(@Valid @RequestBody Input input);

    @PostMapping("multiply")
    BigDecimal multiply(@Valid @RequestBody Input input);

    @PostMapping("divide")
    BigDecimal divide(@Valid @RequestBody Input input);

}
