package edu.ntudp.pzks.lab4.controller;

import edu.ntudp.pzks.lab4.model.Department;
import edu.ntudp.pzks.lab4.model.Faculty;
import edu.ntudp.pzks.lab4.model.Human;

public class FacultyCreator {
    public Faculty createFaculty(String name, Human head) {
        return new Faculty(name, head);
    }

    public void addDepartment(Faculty faculty, Department department) {
        faculty.addDepartment(department);
    }
}