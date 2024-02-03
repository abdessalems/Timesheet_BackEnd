package com.backend.timesheet.Entity;

import lombok.Getter;
import lombok.Setter;

import java.util.SortedSet;
import java.util.TreeSet;

@Getter
@Setter
public class TimeRecords {
    private SortedSet<TimeRecord> records;

    public TimeRecords() {
        this.records = new TreeSet<>();
    }

    public void add(TimeRecord record) {
        if (!overlapsWithExistingRecord(record)) {
            records.add(record);
        } else {
            System.out.println("Error: Time record overlaps with existing records.");
        }
    }

    public SortedSet<TimeRecord> getEmployeeRecords(Employee employee, Day day) {
        SortedSet<TimeRecord> employeeRecords = new TreeSet<>();
        for (TimeRecord record : records) {
            if (record.getEmployee().equals(employee) && record.getDay().equals(day)) {
                employeeRecords.add(record);
            }
        }
        return employeeRecords;
    }

    public boolean overlapsWithExistingRecord(TimeRecord recordCandidate) {
        for (TimeRecord existingRecord : records) {
            if (existingRecord.getEmployee().equals(recordCandidate.getEmployee())
                    && existingRecord.getDay().equals(recordCandidate.getDay())
                    && isOverlap(existingRecord, recordCandidate)) {
                return true;
            }
        }
        return false;
    }

    private boolean isOverlap(TimeRecord record1, TimeRecord record2) {
        return (record1.getBeginning().isBefore(record2.getEnd()) &&
                record2.getBeginning().isBefore(record1.getEnd()));
    }
}
