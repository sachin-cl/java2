package week2.lab;

import java.util.Scanner;

public class AsciiEncryption {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text to encrypt: ");
        String text = scanner.nextLine();

        System.out.print("Enter shift value: ");
        int shift = scanner.nextInt();

        String encrypted = encryptText(text, shift);
        String decrypted = decryptText(encrypted, shift);

        System.out.println("\n--- Encryption Details ---");
        displayAsciiComparison(text, encrypted);

        System.out.println("\n--- Decryption Validation ---");
        System.out.println("Decrypted Text: " + decrypted);
        System.out.println("Is decryption valid? " + validateDecryption(text, decrypted));
    }

    public static String encryptText(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                char shifted = (char) (((c - 'A' + shift) % 26 + 26) % 26 + 'A');
                result.append(shifted);
            } else if (Character.isLowerCase(c)) {
                char shifted = (char) (((c - 'a' + shift) % 26 + 26) % 26 + 'a');
                result.append(shifted);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String decryptText(String encryptedText, int shift) {
        return encryptText(encryptedText, -shift);
    }

    public static void displayAsciiComparison(String original, String encrypted) {
        System.out.println("Original Text: " + original);
        System.out.print("Original ASCII: ");
        for (char c : original.toCharArray()) {
            System.out.print((int) c + " ");
        }
        System.out.println("\nEncrypted Text: " + encrypted);
        System.out.print("Encrypted ASCII: ");
        for (char c : encrypted.toCharArray()) {
            System.out.print((int) c + " ");
        }
        System.out.println();
    }

    public static boolean validateDecryption(String original, String decrypted) {
        return original.equals(decrypted);
    }
}
