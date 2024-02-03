package com.backend.timesheet.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;

    @OneToMany(mappedBy = "day", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TimeRecord> timeRecords;


    public Day(LocalDate date) {
        this.date = date;
    }

    public boolean isWeekend() {
        return date.getDayOfWeek().getValue() > 5; // Assuming Saturday and Sunday are considered weekends
    }
}
