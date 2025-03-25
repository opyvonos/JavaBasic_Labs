package edu.ntudp.pzks.test;

import edu.ntudp.pzks.lab4.json.JsonManager;
import edu.ntudp.pzks.lab4.model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class UniversityTest {
    @Test
    void testUniversityJson() throws IOException {
        University oldUniversity = createUniversity();
        JsonManager.writeToJsonFile(oldUniversity, "University.json");
        University newUniversity = JsonManager.readFromJsonFile("University.json");
        System.out.println(oldUniversity.equals(newUniversity));
    }

    private University createUniversity() {
        Student st1 = new Student("Олег", "Кравченко", "Іванович", Sex.MALE, 1);
        Student st2 = new Student("Владислав", "Захарченко", "Сергійович", Sex.MALE, 2);
        Student st3 = new Student("Валерія", "Мороз", "Романівна", Sex.FEMALE, 3);
        Student st4 = new Student("Анастасія", "Нестеренко", "Вадимівна", Sex.FEMALE, 4);
        Student st5 = new Student("Володимир", "Ткач", "Юрійович", Sex.MALE, 5);

        Group group1 = new Group("122-1", st1);
        group1.addStudent(st1);
        group1.addStudent(st2);

        Group group2 = new Group("121-1", st3);
        group2.addStudent(st3);

        Group group3 = new Group("124-1", st4);
        group3.addStudent(st4);
        group3.addStudent(st5);

        Student pzksHead = new Student("Ольга", "Зімниця", "Василівна", Sex.FEMALE, 6);
        Department pzks = new Department("ПЗКС", pzksHead);
        pzks.addGroup(group1);
        pzks.addGroup(group2);

        Student sauHead = new Student("Сергій", "Кириленко", "Анатолійович", Sex.MALE, 7);
        Department sau = new Department("САУ", sauHead);
        sau.addGroup(group3);

        Student facultyHead = new Student("Софія", "Олійник", "Денисівна", Sex.FEMALE, 8);
        Faculty fit = new Faculty("ФІТ", facultyHead);
        fit.addDepartment(sau);
        fit.addDepartment(pzks);

        Student rector = new Student("Бойко", "Олександр", "Анатолійович", Sex.MALE, 9);
        University ntudp = new University("НТУ ДП", rector);
        ntudp.addFaculty(fit);

        return ntudp;
    }
}
