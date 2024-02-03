package com.backend.timesheet.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int employeeNumber;
    private String firstName;
    private String lastName;


    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TimeRecord> timeRecords;

    @ManyToMany(mappedBy = "employees")
    private Set<Team> teams;
    @ManyToOne
    @JoinColumn(name = "staff_register_id")
    private StaffRegister staffRegister;


}
