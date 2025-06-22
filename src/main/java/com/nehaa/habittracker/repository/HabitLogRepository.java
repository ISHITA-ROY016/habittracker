package com.nehaa.habittracker.repository;

import com.nehaa.habittracker.model.HabitLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface HabitLogRepository extends JpaRepository<HabitLog, Long> {
    // Find logs for a habit on a specific date
    List<HabitLog> findByHabitIdAndDate(Long habitId, LocalDate date);

    // Find logs for the past X days
    List<HabitLog> findByHabitIdAndDateBetween(Long habitId, LocalDate start, LocalDate end);
}
