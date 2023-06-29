package task1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;



public class FileUtils {

    public static Student[] readFile(String filePath) throws FileNotFoundException {
        // implement the actual logic (remove next line)

        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                int studentId = Integer.parseInt(parts[0]);
                String fullName = parts[1];
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

                Student student = new Student(studentId, fullName, dateOfBirth, universityName, departmentCode, departmentName, yearOfEnrollment);
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students.toArray(new Student[0]);

    }

    public static void writeToFile(Student[] students, String filePath) throws IOException {
        // implement the actual logic

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Student student : students) {
                String line = student.getStudentId() + ";" 
                    + student.getFullName() + ";"
                    + formatDate(student.getDateOfBirth()) + ";" 
                    + student.getUniversityName() + ";"
                    + student.getDepartmentCode() + ";" 
                    + student.getDepartmentName() + ";"
                    + student.getYearOfEnrollment() + ";";

                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String formatDate(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }
    
}
