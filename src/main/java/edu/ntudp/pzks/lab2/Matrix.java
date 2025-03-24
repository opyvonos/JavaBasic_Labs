package edu.ntudp.pzks.lab2;

import java.util.Scanner;
import java.util.Random;

public class Matrix {
    public static final int MIN_VAL = -100;
    public static final int MAX_VAL = 100;
    public static final int MAX_SIZE = 20;
    public static final int MIN_SIZE = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість рядків (не більше " + MAX_SIZE + "): ");
        int rows = scanner.nextInt();
        while (rows < MIN_SIZE || rows > MAX_SIZE) {
            System.out.println("Помилка! Кількість рядків повинна бути від " + MIN_SIZE + " до " + MAX_SIZE);
            System.out.print("Введіть кількість рядків знову: ");
            rows = scanner.nextInt();
        }

        System.out.print("Введіть кількість стовпців (не більше " + MAX_SIZE + "): ");
        int cols = scanner.nextInt();
        while (cols < MIN_SIZE || cols > MAX_SIZE) {
            System.out.println("Помилка! Кількість стовпців повинна бути від " + MIN_SIZE + " до " + MAX_SIZE);
            System.out.print("Введіть кількість стовпців знову: ");
            cols = scanner.nextInt();
        }

        System.out.println("Оберіть спосіб створення матриці:\n" +
                "\t\t1 - Введення з клавіатури\n" +
                "\t\t2 - Заповнення випадковими числами");
        System.out.print("Ваш вибір: ");
        int choice = scanner.nextInt();
        int[][] matrix = new int[rows][cols];

        while (true) {
            if (choice == 1) {
                fillMatrixManually(scanner, matrix);
                break;
            } else if (choice == 2) {
                fillMatrixRandomly(matrix);
                break;
            } else {
                System.out.print("Помилка! Будь ласка, виберіть 1 або 2: ");
                choice = scanner.nextInt();
            }
        }

        System.out.println("Матриця:");
        printMatrix(matrix);
        System.out.println("Мінімальний елемент: " + findMinValue(matrix));
        System.out.println("Максимальний елемент: " + findMaxValue(matrix));
        System.out.printf("Середнє арифметичне: %.2f\n", calcArithmeticMean(matrix));
        System.out.printf("Середнє геометричне: %.2f\n", calcGeomMean(matrix));

        scanner.close();
    }

    private static void fillMatrixRandomly(int[][] matrix) {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(MAX_VAL - MIN_VAL + 1) + MIN_VAL;
            }
        }
    }

    private static void fillMatrixManually(Scanner scanner, int[][] matrix) {
        System.out.println("Введіть елементи матриці:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("Введіть елемент [%d][%d]: ", i + 1, j + 1);
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static int findMinValue(int[][] matrix) {
        int minValue = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < minValue) {
                    minValue = matrix[i][j];
                }
            }
        }
        return minValue;
    }

    private static int findMaxValue(int[][] matrix) {
        int maxValue = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > maxValue) {
                    maxValue = matrix[i][j];
                }
            }
        }
        return maxValue;
    }

    private static double calcArithmeticMean(int[][] matrix) {
        double sum = 0;
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
                count++;
            }
        }
        return sum / count;
    }

    private static double calcGeomMean(int[][] matrix) {
        double product = 1;
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                product *= matrix[i][j];
                count++;
            }
        }
        return Math.pow(product, 1.0 / count);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}