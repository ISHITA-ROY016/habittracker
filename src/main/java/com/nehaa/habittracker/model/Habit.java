package com.nehaa.habittracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String recurrence;
    private LocalDate startDate;

    @OneToMany(mappedBy = "habit", cascade = CascadeType.ALL)
    private List<HabitLog> logs;

    public Habit() {}

    public Habit(Long id, String name, String recurrence, LocalDate startDate, List<HabitLog> logs) {
        this.id = id;
        this.name = name;
        this.recurrence = recurrence;
        this.startDate = startDate;
        this.logs = logs;
    }

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRecurrence() { return recurrence; }
    public void setRecurrence(String recurrence) { this.recurrence = recurrence; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public List<HabitLog> getLogs() { return logs; }
    public void setLogs(List<HabitLog> logs) { this.logs = logs; }
}
