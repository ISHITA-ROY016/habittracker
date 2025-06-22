package com.nehaa.habittracker.service;

import com.nehaa.habittracker.dto.*;
import com.nehaa.habittracker.model.Habit;
import com.nehaa.habittracker.model.HabitLog;
import com.nehaa.habittracker.repository.HabitLogRepository;
import com.nehaa.habittracker.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HabitService {

    private final HabitRepository habitRepository;
    private final HabitLogRepository habitLogRepository;

    // ✅ Constructor Injection
    public HabitService(HabitRepository habitRepository, HabitLogRepository habitLogRepository) {
        this.habitRepository = habitRepository;
        this.habitLogRepository = habitLogRepository;
    }

    public HabitResponse createHabit(HabitRequest request) {
        Habit habit = new Habit();
        habit.setName(request.getName());
        habit.setRecurrence(request.getRecurrence());
        habit.setStartDate(LocalDate.now());

        Habit saved = habitRepository.save(habit);

        return new HabitResponse(
                saved.getId(),
                saved.getName(),
                saved.getRecurrence(),
                saved.getStartDate()
        );
    }

    public List<HabitResponse> getAllHabits() {
        return habitRepository.findAll()
                .stream()
                .map(habit -> new HabitResponse(
                        habit.getId(),
                        habit.getName(),
                        habit.getRecurrence(),
                        habit.getStartDate()
                ))
                .collect(Collectors.toList());
    }

    public HabitLogResponse logHabitCompletion(Long habitId) {
        Habit habit = habitRepository.findById(habitId)
                .orElseThrow(() -> new RuntimeException("Habit not found"));

        HabitLog log = new HabitLog();
        log.setHabit(habit);
        log.setDate(LocalDate.now());
        log.setCompleted(true);

        HabitLog savedLog = habitLogRepository.save(log);

        return new HabitLogResponse(
                savedLog.getId(),
                savedLog.getDate(),
                savedLog.isCompleted()
        );
    }

    public List<HabitLogResponse> getHabitLogs(Long habitId, int days) {
        LocalDate end = LocalDate.now();
        LocalDate start = end.minusDays(days);

        return habitLogRepository.findByHabitIdAndDateBetween(habitId, start, end)
                .stream()
                .map(log -> new HabitLogResponse(
                        log.getId(),
                        log.getDate(),
                        log.isCompleted()
                ))
                .collect(Collectors.toList());
    }

    public HabitLogFullResponse logHabitCompletionDetailed(Long habitId) {
        Habit habit = habitRepository.findById(habitId)
                .orElseThrow(() -> new RuntimeException("Habit not found"));

        HabitLog log = new HabitLog();
        log.setHabit(habit);
        log.setDate(LocalDate.now());
        log.setCompleted(true);

        HabitLog savedLog = habitLogRepository.save(log);

        HabitLogFullResponse response = new HabitLogFullResponse();
        response.setHabitId(habit.getId());
        response.setHabitName(habit.getName());
        response.setDate(savedLog.getDate());
        response.setCompleted(savedLog.isCompleted());

        return response;
    }

}
