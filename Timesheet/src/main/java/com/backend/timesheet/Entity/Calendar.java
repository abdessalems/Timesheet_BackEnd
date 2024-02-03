package com.backend.timesheet.Entity;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;

public class Calendar {
    public Day getDay(LocalDate date) {
        return new Day(date);
    }

    public List<Day> getDaysOfWeek(Year year, int weekOfYear) {
        List<Day> daysOfWeek = new ArrayList<>();
        LocalDate firstDayOfWeek = LocalDate.of(year.getValue(), 1, 1)
                .with(WeekFields.ISO.weekOfYear(), weekOfYear)
                .with(DayOfWeek.MONDAY);

        for (int i = 0; i < 7; i++) {
            daysOfWeek.add(getDay(firstDayOfWeek.plusDays(i)));
        }

        return daysOfWeek;
    }

    public List<Day> getDaysOfMonth(YearMonth month) {
        List<Day> daysOfMonth = new ArrayList<>();
        int daysInMonth = month.lengthOfMonth();

        for (int i = 1; i <= daysInMonth; i++) {
            daysOfMonth.add(getDay(month.atDay(i)));
        }

        return daysOfMonth;
    }
}
