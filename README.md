<div align="center">

# 🕒 Timesheet — Domain Model

**JPA domain model for an employee time-tracking system.**

![Java](https://img.shields.io/badge/Java-17-007396?style=flat-square&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-6DB33F?style=flat-square&logo=springboot&logoColor=white)
![Hibernate](https://img.shields.io/badge/JPA%20%2F%20Hibernate-59666C?style=flat-square&logo=hibernate&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white)
![Lombok](https://img.shields.io/badge/Lombok-BC4521?style=flat-square)

</div>

---

The persistence layer of a timesheet application: employees log time against tasks, are grouped into teams, and their hours roll up across a calendar. Modelled with **Spring Boot 3**, **Spring Data JPA / Hibernate** and **Lombok**, targeting **MySQL**.

> **Scope:** this repository contains the **domain model only** — the JPA entities and their relationships. Controllers, services and repositories are not implemented. It is the schema foundation of the application, not a runnable API.

---

## Domain

| Entity | Role |
|---|---|
| `Employee` | A member of staff — employee number, name |
| `Team` | A group of employees (many-to-many with `Employee`) |
| `StaffRegister` | The register an employee belongs to |
| `TimeRecord` | A single logged time entry, owned by an `Employee` |
| `TimeRecords` | A collection wrapper over time entries |
| `Task` | Work that time is booked against |
| `Calendar` | The calendar an entry falls in |
| `Day` | A day within the calendar |

Relationships are mapped with JPA annotations — `@OneToMany` with cascade and orphan removal from `Employee` to `TimeRecord`, `@ManyToMany` between `Employee` and `Team`, `@ManyToOne` from `Employee` to `StaffRegister` — with Jackson annotations to control serialisation across the bidirectional links.

---

## Structure

```
Timesheet/
└── src/main/java/com/backend/timesheet/
    ├── TimesheetApplication.java   Spring Boot entry point
    └── Entity/
        ├── Employee.java
        ├── Team.java
        ├── StaffRegister.java
        ├── TimeRecord.java
        ├── TimeRecords.java
        ├── Task.java
        ├── Calendar.java
        └── Day.java
```

---

## Getting started

**Requirements:** JDK 17, MySQL, Maven (a wrapper is bundled).

```bash
git clone https://github.com/abdessalems/Timesheet_BackEnd.git
cd Timesheet_BackEnd/Timesheet
```

Point `src/main/resources/application.properties` at your database, then:

```bash
./mvnw spring-boot:run
```

Hibernate will generate the schema from the entities. There are no endpoints to call yet.

---

## Roadmap

- [ ] `JpaRepository` interfaces per aggregate
- [ ] Service layer (time booking, validation of overlapping entries)
- [ ] REST controllers
- [ ] Authentication and per-employee authorisation
- [ ] Test coverage
