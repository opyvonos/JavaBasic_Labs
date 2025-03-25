package edu.ntudp.pzks.lab3.controller;

import edu.ntudp.pzks.lab3.model.Department;
import edu.ntudp.pzks.lab3.model.Group;
import edu.ntudp.pzks.lab3.model.Human;

public class DepartmentCreator {
    public Department createDepartment(String name, Human head) {
        return new Department(name, head);
    }

    public void addGroup(Department department, Group group) {
        department.addGroup(group);
    }
}