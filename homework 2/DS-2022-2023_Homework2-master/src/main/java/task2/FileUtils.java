package task2;

import task1.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FileUtils {

    public static RedBlackTree<Integer, Student> readFile(String filePath) throws FileNotFoundException {
        // implement the actual logic (remove next line)
        
        RedBlackTree<Integer, Student> redBlackTree = new RedBlackTree<>();

        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(";");

            int studentId = Integer.parseInt(parts[0]);
            String name = parts[1];
            String dateOfBirthString = parts[2];
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date dateOfBirth = null;
            try {
                dateOfBirth = dateFormat.parse(dateOfBirthString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String universityName = parts[3];
            String departmentCode = parts[4];
            String departmentName = parts[5];
            int yearOfEnrollment = Integer.parseInt(parts[6]);

            Student student = new Student(studentId, name, dateOfBirth, universityName, departmentCode, departmentName, yearOfEnrollment);

            redBlackTree.put(studentId, student);
        }

        scanner.close();

        return redBlackTree;
    }
}
