package com.nehaa.habittracker.dto;

import java.time.LocalDate;

public class HabitResponse {
    private Long id;
    private String name;
    private String recurrence;
    private LocalDate startDate;

    public HabitResponse() {}

    public HabitResponse(Long id, String name, String recurrence, LocalDate startDate) {
        this.id = id;
        this.name = name;
        this.recurrence = recurrence;
        this.startDate = startDate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRecurrence() { return recurrence; }
    public void setRecurrence(String recurrence) { this.recurrence = recurrence; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
}
