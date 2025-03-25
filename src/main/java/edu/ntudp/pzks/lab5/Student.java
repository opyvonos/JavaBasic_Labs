package edu.ntudp.pzks.lab5;

public class Student {
    private int studentId;
    private String lastName;
    private String firstName;
    private String middleName;
    private String birthDate;
    private String recordBookNumber;

    public Student(int studentId, String firstName, String lastName, String middleName, String birthDate, String recordBookNumber) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.recordBookNumber = recordBookNumber;
    }

    public int getId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getRecordBookNumber() {
        return recordBookNumber;
    }

    @Override
    public String toString() {
        return lastName + " " + middleName + " " + firstName + ", дата народження: " +
                birthDate + ", залікова книжка: " + recordBookNumber;
    }
}