package com.nehaa.habittracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class HabitLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "habit_id")
    private Habit habit;

    public HabitLog() {}

    public HabitLog(Long id, LocalDate date, boolean completed, Habit habit) {
        this.id = id;
        this.date = date;
        this.completed = completed;
        this.habit = habit;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public Habit getHabit() { return habit; }
    public void setHabit(Habit habit) { this.habit = habit; }
}
