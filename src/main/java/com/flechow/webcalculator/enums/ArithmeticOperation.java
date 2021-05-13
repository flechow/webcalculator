package com.flechow.webcalculator.enums;

import lombok.Getter;

@Getter
public enum ArithmeticOperation {

    ADD("ADD", "ADD"),
    SUBTRACT("SUBTRACT", "SUBTRACT"),
    MULTIPLY("MULTIPLY", "MULTIPLY"),
    DIVIDE("DIVIDE", "DIVIDE");

    final private String name;

    ArithmeticOperation(String operation, String name) {
        this.name = name;
    }
}
