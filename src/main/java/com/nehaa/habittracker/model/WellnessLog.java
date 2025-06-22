package com.nehaa.habittracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class WellnessLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private int mood;
    private String notes;

    public WellnessLog() {}

    public WellnessLog(Long id, LocalDate date, int mood, String notes) {
        this.id = id;
        this.date = date;
        this.mood = mood;
        this.notes = notes;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public int getMood() { return mood; }
    public void setMood(int mood) { this.mood = mood; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
