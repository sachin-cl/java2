package week2.lab;

import java.util.Scanner;

public class StringPerformanceTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // a. Take user input
        System.out.print("Enter number of iterations (e.g., 1000, 10000, 100000): ");
        int iterations = scanner.nextInt();

        // b. String concatenation using '+'
        PerformanceResult stringResult = testStringConcatenation(iterations);

        // c. StringBuilder
        PerformanceResult builderResult = testStringBuilder(iterations);

        // d. StringBuffer
        PerformanceResult bufferResult = testStringBuffer(iterations);

        // e. Display results
        displayComparison(stringResult, builderResult, bufferResult);
    }

    // b. String concatenation with '+'
    public static PerformanceResult testStringConcatenation(int iterations) {
        String result = "";
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            result += "abc";
        }
        long endTime = System.currentTimeMillis();
        return new PerformanceResult("String (+)", endTime - startTime, result.length());
    }

    // c. StringBuilder.append()
    public static PerformanceResult testStringBuilder(int iterations) {
        StringBuilder sb = new StringBuilder();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            sb.append("abc");
        }
        long endTime = System.currentTimeMillis();
        return new PerformanceResult("StringBuilder", endTime - startTime, sb.length());
    }

    // d. StringBuffer.append()
    public static PerformanceResult testStringBuffer(int iterations) {
        StringBuffer sb = new StringBuffer();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            sb.append("abc");
        }
        long endTime = System.currentTimeMillis();
        return new PerformanceResult("StringBuffer", endTime - startTime, sb.length());
    }

    // e. Display table
    public static void displayComparison(PerformanceResult... results) {
        System.out.println("\n--- Performance Comparison ---");
        System.out.printf("%-15s %-20s %-20s%n", "Method Used", "Time Taken (ms)", "Final String Length");
        System.out.println("--------------------------------------------------------------");
        for (PerformanceResult res : results) {
            System.out.printf("%-15s %-20d %-20d%n", res.method, res.timeTaken, res.finalLength);
        }

        System.out.println("\nMemory Efficiency: Typically, StringBuilder > StringBuffer > String");
    }

    // Helper class to store results
    static class PerformanceResult {
        String method;
        long timeTaken;
        int finalLength;

        PerformanceResult(String method, long timeTaken, int finalLength) {
            this.method = method;
            this.timeTaken = timeTaken;
            this.finalLength = finalLength;
        }
    }
}
