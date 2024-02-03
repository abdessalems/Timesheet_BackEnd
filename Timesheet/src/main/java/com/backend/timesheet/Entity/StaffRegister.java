package com.backend.timesheet.Entity;

import lombok.*;
import jakarta.persistence.*;


import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class StaffRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "staffRegister", cascade = CascadeType.ALL, orphanRemoval = true)
    private SortedSet<Employee> employees;

    @OneToMany(mappedBy = "staffRegister")
    private List<Team> teams;


    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public SortedSet<Employee> getAllEmployees() {
        return employees;
    }

    public List<Team> getAllTeams() {
        return teams;
    }
}
