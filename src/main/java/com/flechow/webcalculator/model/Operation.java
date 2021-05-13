package com.flechow.webcalculator.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Builder
@EqualsAndHashCode
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    BigDecimal result;
    LocalDateTime timestamp;
    String name;

    public Operation() {

    }

    public Operation(Long id, BigDecimal result, LocalDateTime timestamp, String name) {
        this.id = id;
        this.result = result;
        this.timestamp = timestamp;
        this.name = name;
    }
}
