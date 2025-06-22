package com.nehaa.habittracker.controller;

import com.nehaa.habittracker.dto.HabitLogFullResponse;
import com.nehaa.habittracker.dto.HabitLogResponse;
import com.nehaa.habittracker.dto.HabitRequest;
import com.nehaa.habittracker.dto.HabitResponse;
import com.nehaa.habittracker.service.HabitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habits")
public class HabitController {

    @Autowired
    private HabitService habitService;

    // Create new habit
    @PostMapping
    public HabitResponse createHabit(@RequestBody @Valid HabitRequest request) {
        return habitService.createHabit(request);
    }

    // Get all habits
    @GetMapping
    public List<HabitResponse> getAllHabits() {
        return habitService.getAllHabits();
    }

    // Log completion of a habit (detailed response)
    @PostMapping("/{id}/log")
    public HabitLogFullResponse logHabitCompletion(@PathVariable("id") Long id) {
        return habitService.logHabitCompletionDetailed(id);
    }


    // Get logs for the last X days
    @GetMapping("/{id}/logs")
    public List<HabitLogResponse> getLogs(
            @PathVariable("id") Long id,
            @RequestParam(defaultValue = "7") int days
    ) {
        return habitService.getHabitLogs(id, days);
    }
}
