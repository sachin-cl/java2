package week2.Assignment;

import java.util.*;

public class SimpleSpellChecker {

    static final List<String> DICTIONARY = Arrays.asList(
        "apple", "banana", "orange", "grape", "fruit", "computer", "science",
        "programming", "java", "python", "keyboard", "mouse", "monitor", "language"
    );

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text to spell-check:");
        String input = scanner.nextLine().toLowerCase();

        List<String> words = Arrays.asList(input.split("\\s+"));
        System.out.println("\n--- Spell Check Results ---");
        for (String word : words) {
            if (DICTIONARY.contains(word)) {
                System.out.println(word + " -> OK");
            } else {
                String suggestion = getClosestMatch(word);
                if (suggestion != null) {
                    System.out.println(word + " -> Did you mean: " + suggestion + "?");
                } else {
                    System.out.println(word + " -> No suggestion found");
                }
            }
        }
    }

    public static String getClosestMatch(String word) {
        int minDistance = Integer.MAX_VALUE;
        String closestWord = null;

        for (String dictWord : DICTIONARY) {
            int dist = levenshteinDistance(word, dictWord);
            if (dist < minDistance) {
                minDistance = dist;
                closestWord = dictWord;
            }
        }

        return (minDistance <= 2) ? closestWord : null;
    }

    public static int levenshteinDistance(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i <= a.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= b.length(); j++) dp[0][j] = j;

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                int cost = (a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1;
                dp[i][j] = Math.min(
                    Math.min(dp[i - 1][j] + 1,      // deletion
                             dp[i][j - 1] + 1),     // insertion
                             dp[i - 1][j - 1] + cost); // substitution
            }
        }

        return dp[a.length()][b.length()];
    }
}
