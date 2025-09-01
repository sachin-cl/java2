package week2.lab;

import java.util.Scanner;

public class Caseconversion{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        for (char ch : input.toCharArray()) {
            System.out.println("Character: '" + ch + "' | ASCII: " + (int) ch);
            System.out.println("Type: " + classifyCharacter(ch));

            if (Character.isLetter(ch)) {
                char toggled = toggleCase(ch);
                System.out.println("Toggled Case: '" + toggled + "' | ASCII: " + (int) toggled);
                System.out.println("Difference (Upper - Lower): " + Math.abs(((int) ch - (int) toggled)));
            }
            System.out.println();
        }

        System.out.println("Caesar Cipher (shift by 3): " + caesarCipher(input, 3));

        scanner.close();
    }

    public static String classifyCharacter(char ch) {
        if (Character.isUpperCase(ch)) return "Uppercase Letter";
        if (Character.isLowerCase(ch)) return "Lowercase Letter";
        if (Character.isDigit(ch)) return "Digit";
        return "Special Character";
    }

    public static char toggleCase(char ch) {
        if (Character.isUpperCase(ch)) {
            return (char) (ch + 32);
        } else if (Character.isLowerCase(ch)) {
            return (char) (ch - 32);
        }
        return ch;
    }

    public static String caesarCipher(String text, int shift) {
        StringBuilder cipher = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                char shifted = (char) ((ch - base + shift) % 26 + base);
                cipher.append(shifted);
            } else {
                cipher.append(ch);
            }
        }
        return cipher.toString();
    }

    public static void displayASCIITable(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i + " -> " + (char) i);
        }
    }

    public static int[] stringToASCII(String text) {
        int[] asciiValues = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            asciiValues[i] = (int) text.charAt(i);
        }
        return asciiValues;
    }

    public static String asciiToString(int[] asciiValues) {
        StringBuilder result = new StringBuilder();
        for (int value : asciiValues) {
            result.append((char) value);
        }
        return result.toString();
    }
}