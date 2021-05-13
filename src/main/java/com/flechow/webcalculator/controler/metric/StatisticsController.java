package com.flechow.webcalculator.controler.metric;

import com.flechow.webcalculator.service.OperationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/")
public class StatisticsController {

    private final OperationService operationService;

    StatisticsController(OperationService operationService){
        this.operationService = operationService;
    }

    @GetMapping(value = "sumOfLast10Requests")
    public BigDecimal getSumOfLast10Requests(){
        log.info("sumOfLast10Requests endpoint called");
        return operationService.getSumOfLast10Requests();
    }

    @GetMapping(value = "statistic")
    public ResponseEntity<Map<String, Map<String, BigDecimal>>> getAverages(){
        log.info("Stats endpoint called");
        return new ResponseEntity<>(operationService.getAverages(), HttpStatus.OK);
    }
}
