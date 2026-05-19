# Expense Tracker (Java)

## Project Description

Expense Tracker is a Java desktop application developed using Java Swing and SQLite. The system allows users to record, organize, search, sort, and analyze personal expenses. The application demonstrates object-oriented programming concepts, data structures, algorithms, database connectivity, and file input/output implementation.

This project is being developed as a Java final project and follows a layered architecture design:

UI → Service → DAO → SQLite Database

---

## Features

### Expense Management
- Add new expense records
- Delete expense records
- View expenses in a JTable
- Display total expenses
- Filter expenses by:
  - Category
  - Date
  - Month (YYYY-MM)

### Search and Sorting
- Linear Search implementation
- Insertion Sort implementation
- Sort expenses by amount
- Search by category and date

### Data Structures
- ArrayList used for expense storage and manipulation
- HashMap used for category-based expense totals

### Database
- SQLite database integration
- Automatic table creation if database does not exist
- Persistent data storage

### File Input / Output
- Export expenses into text files
- Import expenses from text files
- Data persistence between sessions

---

## Object-Oriented Programming Concepts

### Inheritance
Implemented using:

- Expense
- FoodExpense extends Expense
- TransportExpense extends Expense

### Polymorphism
Method overriding through:

```java
generateReport()
```

### Abstraction
Implemented using interface:

```java
Reportable
```

---

## Algorithms Implemented

### Linear Search
Searches through expense records based on:

- Category
- Date
- Month

Time Complexity:

```text
O(n)
```

### Insertion Sort
Sorts expenses by amount.

Time Complexity:

```text
O(n²)
```

---

## Technologies Used

- Java
- Java Swing
- SQLite JDBC
- NetBeans IDE

---

## Current Project Structure

```text
com.expensetracker
│
├── model
│   ├── Expense.java
│   ├── FoodExpense.java
│   ├── TransportExpense.java
│   └── Reportable.java
│
├── dao
│   └── ExpenseDAO.java
│
├── service
│   └── ExpenseService.java
│
├── file
│   └── FileService.java
│
├── dc
│   └── DatabaseConnection.java
│
└── ui
    └── MainFrame.java
```

---

## Future Improvements

- Monthly analytics dashboard
- Charts and spending visualization
- Budget planning system
- Expense editing feature
- More detailed reports

---

## Author

Wirya Angana
