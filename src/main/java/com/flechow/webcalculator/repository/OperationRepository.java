package com.flechow.webcalculator.repository;

import com.flechow.webcalculator.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {


    Stream<Operation> findAllByTimestampAfter(LocalDateTime timestamp);
}
