package com.flechow.webcalculator.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Data
public final class InputData {

    @NotNull
    @Size(min = 2)
    private List<BigDecimal> numbers;

}
