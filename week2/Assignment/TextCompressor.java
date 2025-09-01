package week2.Assignment;

import java.util.*;

public class TextCompressor {
    public static String compress(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        entryList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        StringBuilder dictionary = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entryList) {
            dictionary.append(entry.getKey());
        }

        Map<Character, Integer> charToIndex = new HashMap<>();
        for (int i = 0; i < dictionary.length(); i++) {
            charToIndex.put(dictionary.charAt(i), i);
        }

        StringBuilder compressed = new StringBuilder();
        for (char c : input.toCharArray()) {
            compressed.append((char) ('A' + charToIndex.get(c)));
        }

        return dictionary.toString() + "|" + compressed.toString();
    }

    public static String decompress(String compressed) {
        String[] parts = compressed.split("\\|");
        String dictionary = parts[0];
        String encoded = parts[1];

        StringBuilder output = new StringBuilder();
        for (char c : encoded.toCharArray()) {
            int index = c - 'A';
            output.append(dictionary.charAt(index));
        }

        return output.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String compressed = compress(input);
        System.out.println("Compressed: " + compressed);

        String decompressed = decompress(compressed);
        System.out.println("Decompressed: " + decompressed);
    }
}
