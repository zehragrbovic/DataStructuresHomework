package task1;

import java.util.Date;

public class Student implements Comparable<Student> {
    private int studentId;
    private String fullName;
    private Date dateOfBirth;
    private String universityName;
    private String departmentCode;
    private String departmentName;
    private int yearOfEnrollment;

    public Student(int studentId, String fullName, Date dateOfBirth, String universityName, String departmentCode, String departmentName, int yearOfEnrollment) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.universityName = universityName;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.yearOfEnrollment = yearOfEnrollment;
    }

    @Override
    public int compareTo(Student o) {
        
        return Integer.compare(this.studentId, o.studentId);
        
    }

    public int getStudentId() {
        return studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getUniversityName() {
        return universityName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getYearOfEnrollment() {
        return yearOfEnrollment;
    }


}
