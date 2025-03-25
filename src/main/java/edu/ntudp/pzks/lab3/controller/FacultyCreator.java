package edu.ntudp.pzks.lab3.controller;

import edu.ntudp.pzks.lab3.model.Department;
import edu.ntudp.pzks.lab3.model.Faculty;
import edu.ntudp.pzks.lab3.model.Human;

public class FacultyCreator {
    public Faculty createFaculty(String name, Human head) {
        return new Faculty(name, head);
    }

    public void addDepartment(Faculty faculty, Department department) {
        faculty.addDepartment(department);
    }
}