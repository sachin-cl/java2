
import java.util.Scanner;

public class StringMethods {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for user input
        System.out.print("Enter your full name (first and last name): ");
        String fullName = scanner.nextLine();

        System.out.print("Enter your favorite programming language: ");
        String language = scanner.nextLine();

        System.out.print("Write a sentence about your programming experience: ");
        String sentence = scanner.nextLine();

        // Process the input
        // 1. Extract first and last name
        int spaceIndex = fullName.indexOf(" ");
        String firstName = fullName.substring(0, spaceIndex);
        String lastName = fullName.substring(spaceIndex + 1);

        // 2. Count total characters (excluding spaces)
        String sentenceWithoutSpaces = sentence.replace(" ", "");
        int charCount = sentenceWithoutSpaces.length();

        // 3. Convert programming language to uppercase
        String languageUppercase = language.toUpperCase();

        // 4. Display a formatted summary
        System.out.println("\n--- Summary ---");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Favorite Language: " + languageUppercase);
        System.out.println("Total Characters in Sentence (no spaces): " + charCount);

        scanner.close();
    }
}

    
