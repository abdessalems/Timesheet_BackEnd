package com.backend.timesheet.Entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

@Getter
@Setter
public class StaffRegister {
    private SortedSet<Employee> employees;
    private SortedSet<Team> teams;

    public StaffRegister() {
        this.employees = new TreeSet<>();
        this.teams = new TreeSet<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public SortedSet<Employee> getAllEmployees() {
        return employees;
    }

    public SortedSet<Team> getAllTeams() {
        return teams;
    }
}
