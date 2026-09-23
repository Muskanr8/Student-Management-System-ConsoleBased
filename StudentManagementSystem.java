import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class InvalidStudentDataException extends Exception {
    public InvalidStudentDataException(String message) {
        super(message);
    }
}

class Student{

    // fields, constructors, getters, setters
    
    int studentId;
    String name;
    int age;
    double marks;

    Student(int studentId, String name, int age, double marks){
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    int getStudentId() {
        return studentId;
    }

    void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }

    double getMarks() {
        return marks;
    }

    void setMarks(double marks) {
        this.marks = marks;
    }
}

class StudentManager{

    // collection and student operations
    /*
    Operations:
        1. Add Student - DONE
        2. View All Students - DONE
        3. Search Student - DONE
        4. Update Student - DONE
        5. Delete Student - DONE
        6. Find Topper - DONE
        7. Calculate Average - DONE
        8. Above Given Mark - DONE
        9. Sort By Marks - DONE
    */

    static Scanner sc = new Scanner(System.in);
    List<Student> students = new ArrayList<>();

    void addStudent(Student student){

        // Add a new student to the collection

        System.out.println("Entering details for student ID: " + student.getStudentId());
        
        try{
            if(students.stream().anyMatch(s -> s.getStudentId() == student.getStudentId())){
                System.out.println("Student with ID " + student.getStudentId() + " already exists.");
                return;
            }
            else if(student.getAge() <= 0){
                try{
                    throw new InvalidStudentDataException("Invalid age. Age cannot be negative or zero.");
                } catch(InvalidStudentDataException e){
                    System.out.println(e.getMessage());
                    return;
                }
            }
            else if(student.getMarks() < 0 || student.getMarks() > 100){
                try{
                    throw new InvalidStudentDataException("Invalid marks. Marks should be between 0 and 100.");
                } catch(InvalidStudentDataException e){
                    System.out.println(e.getMessage());
                    return;
                }
            }
            else{
                students.add(student);
                System.out.println("Student added successfully.");
            }
        } catch(Exception e){
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    List<Student> viewAllStudents(){

        // Return the list of all students
        if(students.isEmpty()){
            System.out.println("No students available.");
        }
        return students;
    }

    Student searchStudent(int studentId){

        // Search for a student by ID

        for(Student s : students){
            if(s.getStudentId() == studentId){
                return s; // Return the student if found
            }
        }   

        return null; // Return null if student not found
    }

    void updateStudent(){

        // Update student details (implementation can be added later)

        System.out.println("Enter your choice to update student details:");
        System.out.println("1. Update Name \n 2. Update Age \n 3. Update Marks \n 4. Exit");

        int choice = sc.nextInt();
        switch(choice){

            case 1: 
                System.out.println("Enter Student ID to update name:");
                int id = sc.nextInt();
                Student studentToUpdate = searchStudent(id);
                if(studentToUpdate != null){
                    System.out.println("Enter new name:");
                    String newName = sc.next();
                    studentToUpdate.setName(newName);
                    System.out.println("Name updated successfully.");
                } else {
                    System.out.println("Student not found.");
                }
                break;

            case 2:
                System.out.println("Enter Student ID to update age:");
                id = sc.nextInt();
                studentToUpdate = searchStudent(id);
                if(studentToUpdate != null){
                    System.out.println("Enter new age:");
                    int newAge = sc.nextInt();
                    if(newAge < 0){
                        System.out.println("Invalid age. Age cannot be negative.");
                    } else {
                        studentToUpdate.setAge(newAge);
                        System.out.println("Age updated successfully.");
                    }
                } else {
                    System.out.println("Student not found.");
                }
                break;

            case 3:
                System.out.println("Enter Student ID to update marks:");
                id = sc.nextInt();
                studentToUpdate = searchStudent(id);
                if(studentToUpdate != null){
                    System.out.println("Enter new marks:");
                    double newMarks = sc.nextDouble();
                    if(newMarks < 0 || newMarks > 100){
                        System.out.println("Invalid marks. Marks should be between 0 and 100.");
                    } else {
                        studentToUpdate.setMarks(newMarks);
                        System.out.println("Marks updated successfully.");
                    }
                } else {
                    System.out.println("Student not found.");
                }
                break;
            
            case 4:
                System.out.println("Exiting update menu.");
                break;
        }
    }

    void deleteStudent(int studentId){

        // Delete a student by ID
        Student studentToDelete = searchStudent(studentId);
        if(studentToDelete != null){
            students.remove(studentToDelete);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    void findTopper(){

        // Find the student with the highest marks
        if(students.isEmpty()){
            System.out.println("No students available.");
            return;
        }

        Student topper = students.get(0);
        for(Student s : students){
            if(s.getMarks() > topper.getMarks()){
                topper = s;
            }
        }

        System.out.println("Topper: " + topper.getName() + " with marks: " + topper.getMarks());
    }

    void calculateAverage(){

        // Calculate the average marks of all students
        if(students.isEmpty()){
            System.out.println("No students available.");
            return;
        }

        double totalMarks = 0;
        for(Student s : students){
            totalMarks += s.getMarks();
        }

        double average = totalMarks / students.size();
        System.out.println("Average Marks: " + average);
    }

    void aboveGivenMark(double mark){

        // Display students with marks above the given mark
        System.out.println("Students with marks above " + mark + ":");
        boolean found = false;

        for(Student s : students){

            if(s.getMarks() > mark){
                System.out.println("Student ID: " + s.getStudentId() + ", Name: " + s.getName() + ", Marks: " + s.getMarks());
                found = true;
            }
        }
        if(!found){
            System.out.println("No students found with marks above " + mark);
        }
    }

    void sortByMarks(){

        // Sort students by marks in descending order
        
        students.sort((s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks()));
        students.stream().forEach(s -> System.out.println("Student ID: " + s.getStudentId() + ", Name: " + s.getName() + ", Marks: " + s.getMarks()));
        System.out.println("Students sorted by marks in descending order.");
    }

}

public class StudentManagementSystem {

    public static void main(String[] args) {

        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        
        
        do {
            System.out.println("\n\n");
            System.out.println("========================================");
            System.out.println("STUDENT MANAGEMENT SYSTEM");
            System.out.println("========================================");
            System.out.println();
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Find Topper");
            System.out.println("7. Calculate Average");
            System.out.println("8. Above Given Mark");
            System.out.println("9. Sort By Marks");
            System.out.println("10. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            System.out.println();

            switch(choice) {
                case 1:
                    // Add student logic
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Student Name: ");
                    String name = sc.next();
                    System.out.print("Enter Student Age: ");
                    int age = sc.nextInt();
                    System.out.print("Enter Student Marks: ");
                    double marks = sc.nextDouble();
                    Student newStudent = new Student(id, name, age, marks);
                    manager.addStudent(newStudent);
                    break;
                case 2:
                    // View all students logic
                    List<Student> allStudents = manager.viewAllStudents();
                    for(Student s : allStudents){
                        System.out.println("Student ID: " + s.getStudentId() + "\n Name: " + s.getName() + "\n Age: " + s.getAge() + "\n Marks: " + s.getMarks());
                    }
                    break;
                case 3:
                    // Search student logic
                    System.out.print("Enter Student ID to search: ");
                    int searchId = sc.nextInt();
                    Student foundStudent = manager.searchStudent(searchId);
                    if(foundStudent != null){
                        System.out.println("Student found: \n Name: " + foundStudent.getName() + "\n Age: " + foundStudent.getAge() + "\n Marks: " + foundStudent.getMarks());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    // Update student logic
                    manager.updateStudent();
                    break;
                case 5:
                    // Delete student logic
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = sc.nextInt();
                    manager.deleteStudent(deleteId);
                    break;
                case 6:
                    // Find topper logic
                    manager.findTopper();
                    break;
                case 7:
                    // Calculate average logic
                    manager.calculateAverage();
                    break;
                case 8:
                    // Above given mark logic
                    System.out.print("Enter the minimum mark: ");
                    double minMark = sc.nextDouble();
                    manager.aboveGivenMark(minMark);
                    break;
                case 9:
                    // Sort by marks logic
                    manager.sortByMarks();
                    break;
                case 10:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while(choice != 10);

        sc.close();
    }
}