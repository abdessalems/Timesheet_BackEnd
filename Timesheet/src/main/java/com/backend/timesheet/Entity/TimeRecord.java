package com.backend.timesheet.Entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class TimeRecord {
    private LocalTime beginning;
    private LocalTime end;
    private Employee employee;
    private Day day;
    private Task task;

    public TimeRecord(Employee employee, Day day, Task task, LocalTime beginning, LocalTime end) {
        this.employee = employee;
        this.day = day;
        this.task = task;
        this.beginning = beginning;
        this.end = end;
    }

    public float getDurationInHours() {
        // Assuming the duration is calculated in hours
        return (float) (end.toSecondOfDay() - beginning.toSecondOfDay()) / 3600.0f;
    }
}
