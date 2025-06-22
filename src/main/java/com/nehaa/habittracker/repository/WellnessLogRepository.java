package com.nehaa.habittracker.repository;

import com.nehaa.habittracker.model.WellnessLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface WellnessLogRepository extends JpaRepository<WellnessLog, Long> {
    List<WellnessLog> findByDateBetween(LocalDate start, LocalDate end);
}
