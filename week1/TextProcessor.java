import java.util.Arrays;
import java.util.Scanner;

public class TextProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ask the user for input
        System.out.println("Enter a paragraph of text:");
        String input = scanner.nextLine();
        
        // Clean the input: trim extra spaces and normalize
        input = input.trim().replaceAll("\\s+", " ");
        
        // Split text into words and sort them
        String[] words = input.split("\\s+");
        Arrays.sort(words);
        
        // Count words and characters (excluding spaces)
        int wordCount = words.length;
        int charCount = input.replace(" ", "").length();
        
        // Display results
        System.out.println("\nWord Count: " + wordCount);
        System.out.println("Character Count (excluding spaces): " + charCount);
        
        // Display sorted words
        System.out.println("\nWords in Alphabetical Order:");
        for (String word : words) {
            System.out.println(word);
        }
        
        // Allow the user to search for a specific word
        System.out.print("\nEnter a word to search for: ");
        String searchWord = scanner.nextLine().toLowerCase();
        
        boolean found = false;
        for (String word : words) {
            if (word.equals(searchWord)) {
                found = true;
                break;
            }
        }
        
        // Print search result
        if (found) {
            System.out.println("The word '" + searchWord + "' was found.");
        } else {
            System.out.println("The word '" + searchWord + "' was not found.");
        }
        
        // Close the scanner 
        scanner.close();
    }
}

