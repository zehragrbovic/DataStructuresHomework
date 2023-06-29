package task1;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class StudentSearchV1 {

    // I did not implement the optional part, I don't see how the binary search would work if the students are not sorted by id

    public static void main(String[] args) {
        // main application logic

        // the unsorted file being read into an array
        System.out.println("Loading the students...");
        Student[] unsortedStudents = null;
        try {
            unsortedStudents = FileUtils.readFile("C:/Users/hp/Downloads/Global_University_Students.csv");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        // the array sorted using merge sort
        System.out.println("Sorting the students...");
        MergeSort.sort(unsortedStudents);

        // the sorted array written to a new CSV file
        System.out.println("Saving the sorted file...");
        try {
            FileUtils.writeToFile(unsortedStudents, "C:/Users/hp/Desktop/sorted_students.csv");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }

        // performing student searches
        System.out.println("System is ready.");
        Scanner scanner = new Scanner(System.in);
        int studentId;
        do {
            System.out.println("");
            System.out.print("Enter a student ID, or -1 to exit: ");
            studentId = scanner.nextInt();

            if (studentId != -1) {
                int index = BinarySearch.search(unsortedStudents, studentId);
                if (index != -1) {
                    Student student = unsortedStudents[index];
                    System.out.println("Student found:");
                    System.out.println("Student ID: " + student.getStudentId());
                    System.out.println("Name and surname: " + student.getFullName());
                    System.out.println("Date of birth: " + student.getDateOfBirth());
                    System.out.println("University: " + student.getUniversityName());                    
                    System.out.println("Department code: " + student.getDepartmentCode());
                    System.out.println("Department: " + student.getDepartmentName());
                    System.out.println("Year of enrolment: " + student.getYearOfEnrollment());
                    System.out.println("");

                    System.out.println("Number of steps: " + (BinarySearch.numSteps + 1));
                } else {
                    System.out.println("Student not found.");
                    System.out.println("Number of steps: " + BinarySearch.numSteps);
                }

                BinarySearch.numSteps = 0; // reset the step count
            }
        } while (studentId != -1);

        scanner.close();

        System.out.println("Program terminated.");
    }
}