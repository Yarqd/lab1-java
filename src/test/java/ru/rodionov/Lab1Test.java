package ru.rodionov;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class Lab1Test {

    // ---------- Task 1: area ----------

    @Test
    void isPointInArea_upperInside() {
        assertTrue(Lab1.isPointInArea(2.0, 3.0));
    }

    @Test
    void isPointInArea_upperBorder() {
        assertTrue(Lab1.isPointInArea(5.0, 2.0));
    }

    @Test
    void isPointInArea_lowerInside() {
        assertTrue(Lab1.isPointInArea(-3.0, -4.0));
    }

    @Test
    void isPointInArea_outside() {
        assertFalse(Lab1.isPointInArea(1.0, 1.0));
    }

    // ---------- Task 3: Fibonacci ----------

    @Test
    void isFibonacci_trueCases() {
        int[] yes = {0, 1, 2, 3, 5, 8, 13};
        for (int k : yes) {
            assertTrue(Lab1.isFibonacci(k), "Expected Fibonacci for k=" + k);
        }
    }

    @Test
    void isFibonacci_falseCases() {
        int[] no = {4, 6, 7, 9, 10, 12};
        for (int k : no) {
            assertFalse(Lab1.isFibonacci(k), "Expected NOT Fibonacci for k=" + k);
        }
    }

    // ---------- Task 2: expression ----------
    // Формула считается внутри task2(), поэтому проверяем КОНСОЛЬНЫЙ ВЫВОД

    @Test
    void task2_printsBigDecimalOne() {
        String out = captureStdout(Lab1::task2);
        assertTrue(out.contains("Результат BigDecimal: 1"),
                () -> "Expected output to contain 'Результат BigDecimal: 1' but was:\n" + out);
    }

    @Test
    void task2_printsAllResults() {
        String out = captureStdout(Lab1::task2);
        assertTrue(out.contains("Результат float:"), () -> "Missing float result:\n" + out);
        assertTrue(out.contains("Результат double:"), () -> "Missing double result:\n" + out);
        assertTrue(out.contains("Результат BigDecimal:"), () -> "Missing BigDecimal result:\n" + out);
    }

    private static String captureStdout(Runnable action) {
        PrintStream oldOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(baos));
            action.run();
            return baos.toString();
        } finally {
            System.setOut(oldOut);
        }
    }
}