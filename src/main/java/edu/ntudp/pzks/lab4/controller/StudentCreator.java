package edu.ntudp.pzks.lab4.controller;

import edu.ntudp.pzks.lab4.model.Sex;
import edu.ntudp.pzks.lab4.model.Student;

public class StudentCreator {
    public Student createStudent(String firstName, String lastName, String patronymic, Sex sex, int studentId) {
        return new Student(firstName, lastName, patronymic, sex, studentId);
    }
}