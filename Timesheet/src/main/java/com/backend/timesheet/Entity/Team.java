package com.backend.timesheet.Entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

@Getter
@Setter
public class Team {
    private String name;
    private SortedSet<Employee> employees;

    public Team(String name, Collection<Employee> employees) {
        this.name = name;
        this.employees = new TreeSet<>(employees);
    }
}
