package com.flechow.webcalculator.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public final class Input {

    @NotNull
    private BigDecimal decimalOne;

    @NotNull
    private BigDecimal decimalTwo;


}
