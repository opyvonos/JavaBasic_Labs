package edu.ntudp.pzks.lab3;

import edu.ntudp.pzks.lab3.controller.*;
import edu.ntudp.pzks.lab3.model.*;

public class Run {
    public static void main(String[] args) {
        createTypicalUniversity();
    }

    public static void createTypicalUniversity() {
        StudentCreator studentCreator = new StudentCreator();
        GroupCreator groupCreator = new GroupCreator();
        DepartmentCreator departmentCreator = new DepartmentCreator();
        FacultyCreator facultyCreator = new FacultyCreator();
        UniversityCreator universityCreator = new UniversityCreator();

        Student st1 = studentCreator.createStudent("Олег", "Кравченко", "Іванович", Sex.MALE, 13);
        Student st2 = studentCreator.createStudent("Владислав", "Захарченко", "Сергійович", Sex.MALE, 2);
        Student st3 = studentCreator.createStudent("Валерія", "Мороз", "Романівна", Sex.FEMALE, 6);
        Student st4 = studentCreator.createStudent("Анастасія", "Нестеренко", "Вадимівна", Sex.FEMALE, 11);
        Student st5 = studentCreator.createStudent("Володимир", "Ткач", "Юрійович", Sex.MALE, 19);

        Group group1 = groupCreator.createGroup("122-1", st1);
        groupCreator.addStudent(group1, st1);
        groupCreator.addStudent(group1, st2);

        Group group2 = groupCreator.createGroup("121-1", st3);
        groupCreator.addStudent(group2, st3);

        Group group3 = groupCreator.createGroup("124-1", st4);
        groupCreator.addStudent(group3, st4);
        groupCreator.addStudent(group3, st5);

        Human pzksHead = new Human("Ольга", "Зімниця", "Василівна", Sex.FEMALE) {};
        Department pzks = departmentCreator.createDepartment("ПЗКС", pzksHead);
        departmentCreator.addGroup(pzks, group1);
        departmentCreator.addGroup(pzks, group2);

        Human sauHead = new Human("Сергій", "Кириленко", "Анатолійович", Sex.MALE) {};
        Department sau = departmentCreator.createDepartment("САУ", sauHead);
        departmentCreator.addGroup(sau, group3);

        Human facultyHead = new Human("Софія", "Олійник", "Денисівна", Sex.FEMALE) {};
        Faculty fit = facultyCreator.createFaculty("ФІТ", facultyHead);
        facultyCreator.addDepartment(fit, sau);
        facultyCreator.addDepartment(fit, pzks);

        Human rector = new Human("Бойко", "Олександр", "Анатолійович", Sex.MALE) {};
        University ntudp = universityCreator.createUniversity("НТУ ДП", rector);
        universityCreator.addFaculty(ntudp, fit);

        System.out.println(ntudp);
        System.out.println(group1);
        System.out.println(group2);
        System.out.println(group3);
    }
}