package com.backend.timesheet.Entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Day {
    private LocalDate date;

    public Day(LocalDate date) {
        this.date = date;
    }

    public boolean isWeekend() {
        return date.getDayOfWeek().getValue() > 5; //  Saturday and Sunday are considered weekends
    }
}
