package ru.rodionov;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Lab1 {

    private static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu() {
        while (true) {
            printMenu();

            int choice = readIntInRange(0, 3);

            switch (choice) {
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    task3();
                    break;
                case 0:
                    System.out.println("Выход. До свидания!");
                    return;
            }

            System.out.println();
        }
    }

    //Данный метод выводит экранное меню для выбора задачи
    public static void printMenu() {
        System.out.println("Выберите, какую задачу будем решать:");
        System.out.println("1 — Задача 1: принадлежность точки области");
        System.out.println("2 — Задача 2: вычисление выражения (float/double/BigDecimal)");
        System.out.println("3 — Задача 3: ");
        System.out.println("0 — Выход");
    }

    public static int readIntInRange(int min, int max) {
        while (true) {
            System.out.print("Введите номер пункта: ");
            if (SC.hasNextInt()) {
                int value = SC.nextInt();
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Ошибка: выберите число от " + min + " до " + max);
                }
            } else {
                System.out.println("Ошибка: введите целое число.");
                SC.next();
            }
        }
    }

    public static void task1() {
        System.out.println("Задача 1: принадлежность точки области");

        double x = 0;
        double y = 0;

        // Используем цикл for (для выполнения требования по всем типам циклов)
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                x = readDouble("Введите X: ");
            } else {
                y = readDouble("Введите Y: ");
            }
        }

        boolean result = isPointInArea(x, y);

        System.out.println("Точка принадлежит заштрихованной области: " + result);
    }

    public static void task2() {
        System.out.println("Задача 2: вычисление выражения разными типами");

        float aFloat = 1000f;
        float bFloat = 0.0001f;

        double aDouble = 1000.0;
        double bDouble = 0.0001;

        java.math.BigDecimal aBig = new java.math.BigDecimal("1000");
        java.math.BigDecimal bBig = new java.math.BigDecimal("0.0001");

        // float
        float numeratorFloat =
                (float) Math.pow(aFloat - bFloat, 4)
                        - (float) (Math.pow(aFloat, 4)
                        + 6 * Math.pow(aFloat, 2) * Math.pow(bFloat, 2)
                        + Math.pow(bFloat, 4));

        float denominatorFloat =
                (float) (-4 * aFloat * Math.pow(bFloat, 3)
                        - 4 * Math.pow(aFloat, 3) * bFloat);

        float resultFloat = numeratorFloat / denominatorFloat;

        // double
        double numeratorDouble =
                Math.pow(aDouble - bDouble, 4)
                        - (Math.pow(aDouble, 4)
                        + 6 * Math.pow(aDouble, 2) * Math.pow(bDouble, 2)
                        + Math.pow(bDouble, 4));

        double denominatorDouble =
                -4 * aDouble * Math.pow(bDouble, 3)
                        - 4 * Math.pow(aDouble, 3) * bDouble;

        double resultDouble = numeratorDouble / denominatorDouble;

        // BigDecimal
        java.math.BigDecimal numeratorBig =
                aBig.subtract(bBig).pow(4)
                        .subtract(
                                aBig.pow(4)
                                        .add(
                                                aBig.pow(2)
                                                        .multiply(bBig.pow(2))
                                                        .multiply(new java.math.BigDecimal("6"))
                                        )
                                        .add(bBig.pow(4))
                        );

        java.math.BigDecimal denominatorBig =
                aBig.multiply(bBig.pow(3))
                        .multiply(new java.math.BigDecimal("-4"))
                        .subtract(
                                aBig.pow(3)
                                        .multiply(bBig)
                                        .multiply(new java.math.BigDecimal("4"))
                        );

        java.math.BigDecimal resultBig = numeratorBig.divide(denominatorBig);

        System.out.println("Результат float:  " + resultFloat);
        System.out.println("Результат double: " + resultDouble);
        System.out.println("Результат BigDecimal: " + resultBig);
    }

    public static void task3() {
        System.out.println("Задача 3: проверка числа Фибоначчи");

        int k = readIntInRange(0, Integer.MAX_VALUE);

        boolean result = isFibonacci(k);

        if (result) {
            System.out.println("Число " + k + " является числом Фибоначчи");
        } else {
            System.out.println("Число " + k + " НЕ является числом Фибоначчи");
        }
    }

    public static boolean isFibonacci(int k) {
        if (k == 0) {
            return true;
        }

        int a = 0;
        int b = 1;

        do {
            int c = a + b;
            a = b;
            b = c;
        } while (b < k);

        return b == k;
    }

    public static boolean isPointInArea(double x, double y) {
        boolean upperRectangle =
                x >= 0 && x <= 5 &&
                y >= 2 && y <= 5;

        boolean lowerRectangle =
                x >= -7 && x <= 0 &&
                y >= -5 && y <= -3;

        return upperRectangle || lowerRectangle;
    }

    public static double readDouble(String message) {
        while (true) {
            System.out.print(message);
            if (SC.hasNextDouble()) {
                return SC.nextDouble();
            } else {
                System.out.println("Ошибка: введите число.");
                SC.next();
            }
        }
    }

}
