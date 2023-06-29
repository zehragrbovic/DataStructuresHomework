package task2;

import java.io.FileNotFoundException;
import java.util.Scanner;

import task1.Student;

public class StudentSearchV2 {

    public static void main(String[] args) {
        // main application logic


        RedBlackTree<Integer, Student> redBlackTree;
        System.out.println("Loading the students into the tree...");
        try {
            redBlackTree = FileUtils.readFile("C:/Users/hp/Downloads/Global_University_Students.csv");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: unsorted_students.csv");
            return;
        }

        // Print the number of red links in the tree
        int redLinkCount = redBlackTree.countRedLinks();
        System.out.println("Number of red links: " + redLinkCount);

        Scanner scanner = new Scanner(System.in);
        int studentId;
        System.out.println("The system is ready.");
        do {
            // Prompt the user to enter a student ID
        System.out.println("");
            System.out.print("Enter student ID, or -1 to exit: ");
            studentId = scanner.nextInt();

            if (studentId != -1) {
                // Search for the student in the red-black tree
                Student student = redBlackTree.get(studentId);
                int numSteps = redBlackTree.getNumSteps();

                if (student != null) {
                    // Student found, print details and number of steps
                    System.out.println("Student found:");
                    System.out.println("Student ID: " + student.getStudentId());
                    System.out.println("Full Name: " + student.getFullName());
                    System.out.println("Date of birth: " + student.getDateOfBirth());
                    System.out.println("University: " + student.getUniversityName());                    
                    System.out.println("Department code: " + student.getDepartmentCode());
                    System.out.println("Department: " + student.getDepartmentName());
                    System.out.println("Year of enrolment: " + student.getYearOfEnrollment());
                    System.out.println("");

                    System.out.println("Number of steps: " + numSteps);
                } else {
                    // Student not found
                    System.out.println("Student not found.");
                    System.out.println("Number of steps: " + numSteps);
                }
            }
        } while (studentId != -1);

        // Close the scanner
        scanner.close();

    }
}
