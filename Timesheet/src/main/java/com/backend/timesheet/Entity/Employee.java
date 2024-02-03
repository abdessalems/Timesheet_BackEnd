package com.backend.timesheet.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.SortedSet;
import java.util.TreeSet;

@Getter
@Setter
public class Employee {
    private int employeeNumber;
    private String firstName;
    private String lastName;
    private SortedSet<TimeRecord> timeRecords;

    public Employee(int employeeNumber, String firstName, String lastName) {
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.timeRecords = new TreeSet<>();
    }
}
