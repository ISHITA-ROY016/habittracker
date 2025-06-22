package com.nehaa.habittracker.dto;

import java.time.LocalDate;

public class HabitLogFullResponse {
    private Long habitId;
    private String habitName;
    private LocalDate date;
    private boolean completed;

    public HabitLogFullResponse() {}

    public HabitLogFullResponse(Long habitId, String habitName, LocalDate date, boolean completed) {
        this.habitId = habitId;
        this.habitName = habitName;
        this.date = date;
        this.completed = completed;
    }

    // Getters and Setters
    public Long getHabitId() { return habitId; }
    public void setHabitId(Long habitId) { this.habitId = habitId; }

    public String getHabitName() { return habitName; }
    public void setHabitName(String habitName) { this.habitName = habitName; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
