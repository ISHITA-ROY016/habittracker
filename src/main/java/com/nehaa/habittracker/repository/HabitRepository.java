package com.nehaa.habittracker.repository;

import com.nehaa.habittracker.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitRepository extends JpaRepository<Habit, Long> {
    // You can add custom queries later like:
    List<Habit> findByNameContainingIgnoreCase(String name);
    List<Habit> findByRecurrence(String recurrence);
}
