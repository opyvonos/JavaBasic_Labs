package edu.ntudp.pzks.lab5;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DBManager dbManager = new DBManager();

        System.out.print("Введіть місяць (1-12): ");
        int month = scanner.nextInt();

        List<Student> students = dbManager.getStudentsByBirthMonth(month);

        if (students.isEmpty()) {
            System.out.println("Студентів, які народилися у цьому місяці, немає.");
        } else {
            System.out.println("Студенти, які народилися у місяці " + month + ":");
            students.forEach(System.out::println);
        }
    }
}