package week2;

import java.util.Scanner;

public class AdvancedStringAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ADVANCED STRING ANALYZER ===");

        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        performAllComparisons(str1, str2);

        scanner.close();
    }

    public static double calculateSimilarity(String str1, String str2) {
        return 0.0;
    }

    public static void performAllComparisons(String str1, String str2) {
        System.out.println("Reference equality: " + (str1 == str2));
        System.out.println("Content equality: " + str1.equals(str2));
        System.out.println("Case-insensitive equality: " + str1.equalsIgnoreCase(str2));
        System.out.println("Lexicographic comparison: " + str1.compareTo(str2));
        System.out.println("Case-insensitive lexicographic comparison: " + str1.compareToIgnoreCase(str2));
        System.out.println("Similarity percentage: " + calculateSimilarity(str1, str2) + "%");
    }

    public static void analyzeMemoryUsage(String... strings) {
        for (String s : strings) {
            if (s != null) {
                System.out.println("String: \"" + s + "\" | Length: " + s.length() + " | Approx. Memory: " + (40 + 2 * s.length()) + " bytes");
            }
        }
    }

    public static String optimizedStringProcessing(String[] inputs) {
        StringBuilder sb = new StringBuilder();
        for (String s : inputs) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void demonstrateStringIntern() {
        String s1 = new String("hello");
        String s2 = "hello";
        String s3 = s1.intern();

        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("s2 == s3: " + (s2 == s3));
    }
}
