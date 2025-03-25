package edu.ntudp.pzks.lab4.controller;

import edu.ntudp.pzks.lab4.model.Group;
import edu.ntudp.pzks.lab4.model.Human;
import edu.ntudp.pzks.lab4.model.Student;

public class GroupCreator {
    public Group createGroup(String name, Human head) {
        return new Group(name, head);
    }

    public void addStudent(Group group, Student student) {
        group.addStudent(student);
    }
}