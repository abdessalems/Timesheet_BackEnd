package com.backend.timesheet.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class TimeRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "timeRecords")
    private List<TimeRecord> records;


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
