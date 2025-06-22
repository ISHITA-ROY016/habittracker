package com.nehaa.habittracker.dto;

import jakarta.validation.constraints.NotBlank;

public class HabitRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Recurrence is required")
    private String recurrence;

    public HabitRequest() {}

    public HabitRequest(String name, String recurrence) {
        this.name = name;
        this.recurrence = recurrence;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRecurrence() { return recurrence; }
    public void setRecurrence(String recurrence) { this.recurrence = recurrence; }
}
