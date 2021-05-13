package com.flechow.webcalculator.service;

import com.flechow.webcalculator.enums.ArithmeticOperation;
import com.flechow.webcalculator.model.Operation;
import com.flechow.webcalculator.repository.OperationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Stream;

import static com.flechow.webcalculator.enums.ArithmeticOperation.*;

@Service
@Transactional(readOnly = true)
public class OperationService {

    private static final long SECONDS_IN_MINUTE = 60;
    private static final long SECONDS_IN_HOUR = SECONDS_IN_MINUTE * 60;
    private static final long SECONDS_IN_DAY = SECONDS_IN_HOUR * 24;

    final private OperationRepository operationRepository;

    OperationService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public BigDecimal getSumOfLast10Requests() {
        return operationRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Operation::getTimestamp).reversed())
                .limit(10)
                .map(Operation::getResult)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    public Map<String, Map<String, BigDecimal>> getAverages() {
        return Map.of("Last minute", getAverageRequestsPerSecondLastMinute(),
                "Last hour", getAverageRequestsPerSecondLastHour(),
                "Last day", getAverageRequestsPerSecondLastDay());
    }

    public Map<String, BigDecimal> getAverageRequestsPerSecondLastMinute() {

        return Map.of(ADD.getName(), getAverage(ADD, SECONDS_IN_MINUTE),
                SUBTRACT.getName(), getAverage(SUBTRACT, SECONDS_IN_MINUTE),
                MULTIPLY.getName(), getAverage(MULTIPLY, SECONDS_IN_MINUTE),
                DIVIDE.getName(), getAverage(DIVIDE, SECONDS_IN_MINUTE));

    }

    public Map<String, BigDecimal> getAverageRequestsPerSecondLastHour() {

        return Map.of(ADD.getName(), getAverage(ADD, SECONDS_IN_HOUR),
                SUBTRACT.getName(), getAverage(SUBTRACT, SECONDS_IN_MINUTE),
                MULTIPLY.getName(), getAverage(MULTIPLY, SECONDS_IN_MINUTE),
                DIVIDE.getName(), getAverage(DIVIDE, SECONDS_IN_MINUTE));

    }

    public Map<String, BigDecimal> getAverageRequestsPerSecondLastDay() {

        return Map.of(ADD.getName(), getAverage(ADD, SECONDS_IN_DAY),
                SUBTRACT.getName(), getAverage(SUBTRACT, SECONDS_IN_MINUTE),
                MULTIPLY.getName(), getAverage(MULTIPLY, SECONDS_IN_MINUTE),
                DIVIDE.getName(), getAverage(DIVIDE, SECONDS_IN_MINUTE));

    }

    private BigDecimal getAverage(ArithmeticOperation operationType, long seconds) {
        return BigDecimal.valueOf(getTotalRequestsLastMinute(operationType, seconds) / seconds);
    }

    private double getTotalRequestsLastMinute(ArithmeticOperation operationType, long seconds) {
        return getNumberOfRequests(operationType.getName(), LocalDateTime.now().minusSeconds(seconds));
    }

    double getNumberOfRequests(String name, LocalDateTime timestamp) {
        try (Stream<Operation> foundOperations = operationRepository.findAllByTimestampAfter(timestamp)
                .filter(operation -> operation.getName().equals(name))) {
            return (double) foundOperations.count();
        }
    }
}
