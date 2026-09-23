🎓 Student Management System

A console-based Student Management System developed using Core Java as part of my Java Practice Track.

This project was built to practice Object-Oriented Programming, Collections, Exception Handling, Lambda Expressions, and Java 8 features through a small real-world application.

---

📌 Project Overview

The Student Management System allows users to manage student records through a menu-driven console application.

The system supports:

- Adding students
- Viewing all students
- Searching for a student
- Updating student details
- Deleting students
- Finding the topper
- Calculating average marks
- Finding students above a given mark
- Sorting students by marks

The application is implemented as a single Java file.

---

🛠️ Technologies & Concepts

Language

- Java

Core Java Concepts

- Classes & Objects
- Encapsulation
- Constructors
- Getters & Setters
- Methods
- Conditional Statements
- Loops
- Switch Statements

Collections

- "List"
- "ArrayList"

Exception Handling

- "try-catch"
- Custom Exception
- "InvalidStudentDataException"

Java 8 Features

- Lambda Expressions
- Stream API
- "anyMatch()"
- "forEach()"

Other Concepts

- "Comparator"
- Menu-driven programming
- Input handling using "Scanner"

---

📂 Project Structure

StudentManagementSystem.java

The application contains three main components:

Student
    ↓
StudentManager
    ↓
StudentManagementSystem

"Student"

Represents an individual student.

Properties:

studentId
name
age
marks

The class provides a constructor along with getters and setters.

"StudentManager"

Responsible for managing the collection of students and implementing the application's operations.

"StudentManagementSystem"

Contains the "main()" method and provides the menu-driven user interface.

---

⚙️ Features

1. Add Student

Allows the user to add a new student.

Validation includes:

- Unique Student ID
- Age greater than zero
- Marks between 0 and 100

---

2. View All Students

Displays all student records currently stored in the system.

---

3. Search Student

Searches for a student using their Student ID.

Enter Student ID to search: 101

If the student exists, their details are displayed.

---

4. Update Student

Allows the user to update:

- Student name
- Student age
- Student marks

---

5. Delete Student

Removes a student from the collection using their Student ID.

---

6. Find Topper

Finds the student with the highest marks.

---

7. Calculate Average Marks

Calculates the average marks of all students.

Average Marks: 84.5

---

8. Find Students Above Given Marks

Allows the user to enter a minimum mark and displays students who scored above it.

---

9. Sort Students By Marks

Students are sorted in descending order of marks.

Lambda expression with "Comparator" is used for the sorting operation.

---

🧩 Exception Handling

A custom exception is implemented:

InvalidStudentDataException

It is used while validating student data such as invalid age and marks.

Example validation:

Invalid age. Age cannot be negative or zero.

Invalid marks. Marks should be between 0 and 100.

---

☕ Java 8 Usage

This project also incorporates Java 8 concepts.

Lambda Expression

Student IDs are checked using:

students.stream()
        .anyMatch(s -> s.getStudentId() == student.getStudentId());

Lambda + Comparator

Students are sorted by marks in descending order:

students.sort(
    (s1, s2) -> Double.compare(
        s2.getMarks(),
        s1.getMarks()
    )
);

Stream API

The project also uses Stream API for processing student data.

---

🖥️ Application Menu

========================================
STUDENT MANAGEMENT SYSTEM
========================================

1. Add Student
2. View All Students
3. Search Student
4. Update Student
5. Delete Student
6. Find Topper
7. Calculate Average
8. Above Given Mark
9. Sort By Marks
10. Exit

---

▶️ How to Run

1. Clone the repository

git clone <your-repository-url>

2. Navigate to the project directory

cd StudentManagementSystem

3. Compile the Java file

javac StudentManagementSystem.java

4. Run the application

java StudentManagementSystem

---

📚 What I Practiced

Through this project, I practiced:

- Designing classes using OOP principles
- Encapsulation using getters and setters
- Managing objects using "ArrayList"
- Separating data and business logic
- Searching and manipulating collections
- Exception handling
- Creating custom exceptions
- Using Java 8 lambda expressions
- Using Stream API
- Sorting objects with "Comparator"
- Building menu-driven console applications

---

🚀 Future Improvements

Possible improvements for future versions:

- Add file persistence
- Add serialization
- Add more advanced Stream API operations
- Improve input validation
- Add student grades/categories
- Add sorting by multiple fields
- Add a graphical interface
- Connect the application to a database

---

👩‍💻 Author

Muskan Shaik

B.Tech — Computer Science & Engineering

---

📌 Java Practice Track

Assignment 01 — Student Management System

Built as part of my hands-on Java practice after completing Core Java and Java 8 features.