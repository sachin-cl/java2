package week2.lab;

import java.util.*;

public class TextJustifier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the text to justify:");
        String text = scanner.useDelimiter("\\A").next(); // read full paragraph input

        scanner = new Scanner(System.in); // reset scanner
        System.out.print("Enter the line width to justify text: ");
        int width = scanner.nextInt();

        List<String> justifiedLines = justifyText(text, width);

        System.out.println("\n--- Justified Text ---");
        for (String line : justifiedLines) {
            System.out.println(line);
        }
    }

    public static List<String> justifyText(String text, int width) {
        List<String> result = new ArrayList<>();
        String[] words = text.split("\\s+");
        List<String> lineWords = new ArrayList<>();
        int lineLength = 0;

        for (String word : words) {
            if (lineLength + word.length() + lineWords.size() > width) {
                result.add(justifyLine(lineWords, lineLength, width));
                lineWords.clear();
                lineLength = 0;
            }
            lineWords.add(word);
            lineLength += word.length();
        }

        StringBuilder lastLine = new StringBuilder(String.join(" ", lineWords));
        while (lastLine.length() < width) {
            lastLine.append(" ");
        }
        result.add(lastLine.toString());

        return result;
    }

    public static String justifyLine(List<String> words, int lineLength, int width) {
        if (words.size() == 1) {
            StringBuilder sb = new StringBuilder(words.get(0));
            while (sb.length() < width) sb.append(" ");
            return sb.toString();
        }

        int totalSpaces = width - lineLength;
        int gaps = words.size() - 1;
        int minSpaces = totalSpaces / gaps;
        int extraSpaces = totalSpaces % gaps;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            sb.append(words.get(i));
            if (i < gaps) {
                for (int s = 0; s < minSpaces; s++) sb.append(" ");
                if (i < extraSpaces) sb.append(" ");
            }
        }
        return sb.toString();
    }
}
