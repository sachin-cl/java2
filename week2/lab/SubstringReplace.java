package week2.lab;

import java.util.*;

public class SubstringReplace {

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    
        System.out.print("Enter the main text: ");
        String mainText = scanner.nextLine();

        System.out.print("Enter the substring to find: ");
        String toFind = scanner.nextLine();

        System.out.print("Enter the substring to replace with: ");
        String toReplace = scanner.nextLine();

        // b. Find all occurrences
        List<Integer> positions = findAllOccurrences(mainText, toFind);

        // c. Manually replace substring
        String manuallyReplaced = manualReplace(mainText, toFind, toReplace, positions);

        // Using built-in method
        String builtInReplaced = mainText.replace(toFind, toReplace);

        // d. Compare results
        boolean areEqual = compareStrings(manuallyReplaced, builtInReplaced);

        // e. Display results
        System.out.println("\n--- Results ---");
        System.out.println("Manual Replacement: " + manuallyReplaced);
        System.out.println("Built-in Replacement: " + builtInReplaced);
        System.out.println("Are both equal? " + areEqual);
    }

    // b. Method to find all starting positions of a substring
    public static List<Integer> findAllOccurrences(String text, String target) {
        List<Integer> positions = new ArrayList<>();
        int index = text.indexOf(target);
        while (index != -1) {
            positions.add(index);
            index = text.indexOf(target, index + target.length());
        }
        return positions;
    }

    // c. Manual replacement using charAt and skipping characters
    public static String manualReplace(String text, String toFind, String toReplace, List<Integer> positions) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        int findLength = toFind.length();
        Set<Integer> startPositions = new HashSet<>(positions);

        while (i < text.length()) {
            if (startPositions.contains(i)) {
                result.append(toReplace);
                i += findLength;
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    // d. Compare strings
    public static boolean compareStrings(String s1, String s2) {
        return s1.equals(s2);
    }
}