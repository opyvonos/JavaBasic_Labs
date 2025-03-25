package edu.ntudp.pzks.lab3.controller;

import edu.ntudp.pzks.lab3.model.Faculty;
import edu.ntudp.pzks.lab3.model.Human;
import edu.ntudp.pzks.lab3.model.University;

public class UniversityCreator {
    public University createUniversity(String name, Human head) {
        return new University(name, head);
    }

    public void addFaculty(University university, Faculty faculty) {
        university.addFaculty(faculty);
    }
}