package edu.ntudp.pzks.lab4.model;

public class Student extends Human {
    private int studentId;

    public Student(String firstName, String lastName, String patronymic, Sex sex, int studentId) {
        super(firstName, lastName, patronymic, sex);
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}