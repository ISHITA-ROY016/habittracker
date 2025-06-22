package com.nehaa.habittracker.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class WellnessLogRequest {

    @NotNull(message = "Date is required")
    private LocalDate date;

    @Min(value = 1, message = "Mood must be at least 1")
    @Max(value = 5, message = "Mood cannot be more than 5")
    private int mood;
    private String notes;

    public WellnessLogRequest() {}

    public WellnessLogRequest(LocalDate date, int mood, String notes) {
        this.date = date;
        this.mood = mood;
        this.notes = notes;
    }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public int getMood() { return mood; }
    public void setMood(int mood) { this.mood = mood; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
