# ⏱️ Timesheet — Spring Boot Backend

![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2-6DB33F?logo=springboot&logoColor=white)
![Hibernate](https://img.shields.io/badge/JPA%2FHibernate-59666C?logo=hibernate&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=white)
![Lombok](https://img.shields.io/badge/Lombok-BC4521)
![Maven](https://img.shields.io/badge/Maven-C71A36?logo=apachemaven&logoColor=white)

A **Spring Boot** backend for a **timesheet / time-tracking** system. Employees log time records (start/end) against tasks and days, are grouped into teams, and are organised under a staff register — modeled with JPA entities and relationships persisted to MySQL.

> The application module lives in the [`Timesheet/`](Timesheet) folder.

---

## 🧩 Domain model

| Entity | Purpose |
|--------|---------|
| **Employee** | A worker (number, first/last name) who logs time |
| **Team** | A group of employees (many-to-many with Employee) |
| **StaffRegister** | Groups employees under a register |
| **Task** | Work a time record is booked against |
| **TimeRecord** | A single start→end time entry for an employee, on a day, for a task |
| **TimeRecords** | A collection/grouping of time records |
| **Calendar** / **Day** | Calendar structure the records are organised by |

**Key relationships**
- `Employee` 1—* `TimeRecord` (an employee has many time entries)
- `Employee` *—* `Team` (many-to-many)
- `Employee` *—1 `StaffRegister`
- `TimeRecord` *—1 `Employee`, `Day`, `Task`, `TimeRecords`

---

## 🛠️ Tech stack

- **Java 17**, **Spring Boot 3.2**
- **Spring Data JPA / Hibernate** (ORM)
- **MySQL** (database)
- **Lombok** (boilerplate reduction)
- **Maven** (build, via `mvnw` wrapper)

---

## 🚀 Getting started

**Prerequisites:** JDK 17, MySQL, Maven (or use the included `mvnw` wrapper).

1. Create a MySQL database and set your credentials in
   `Timesheet/src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/timesheet
   spring.datasource.username=YOUR_USER
   spring.datasource.password=YOUR_PASSWORD
   spring.jpa.hibernate.ddl-auto=update
   ```
2. Run the app:
   ```bash
   cd Timesheet
   ./mvnw spring-boot:run
   ```

---

## 🗺️ Roadmap

- [x] JPA domain model (employees, teams, tasks, time records, calendar)
- [ ] REST controllers + service layer (CRUD for time records)
- [ ] Repositories & business queries (hours per employee / team / period)
- [ ] Validation and API documentation (Swagger)
