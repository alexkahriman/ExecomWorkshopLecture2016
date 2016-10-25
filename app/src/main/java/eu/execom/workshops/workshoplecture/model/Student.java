package eu.execom.workshops.workshoplecture.model;

/**
 * Model representing a student.
 * Created by Alex on 10/24/16.
 */

public class Student {

    private final String fullName;

    private final String faculty;

    private final int yearOfStudy;

    public Student(String fullName, String faculty, int yearOfStudy) {
        this.fullName = fullName;
        this.faculty = faculty;
        this.yearOfStudy = yearOfStudy;
    }

    public String getFullName() {
        return fullName;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", faculty='" + faculty + '\'' +
                ", yearOfStudy=" + yearOfStudy +
                '}';
    }
}
