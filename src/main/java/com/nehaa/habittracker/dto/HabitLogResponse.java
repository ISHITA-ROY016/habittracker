package com.nehaa.habittracker.dto;

import java.time.LocalDate;

public class HabitLogResponse {
    private Long id;
    private LocalDate date;
    private boolean completed;

    public HabitLogResponse() {}

    public HabitLogResponse(Long id, LocalDate date, boolean completed) {
        this.id = id;
        this.date = date;
        this.completed = completed;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
