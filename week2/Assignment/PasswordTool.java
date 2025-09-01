package week2.Assignment;

import java.util.*;

public class PasswordTool {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a password to analyze: ");
        String password = scanner.nextLine();

        analyzePassword(password);

        System.out.print("\nGenerate a strong password? (yes/no): ");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("yes")) {
            System.out.print("Enter desired length (min 8): ");
            int length = scanner.nextInt();
            String strongPassword = generateStrongPassword(length);
            System.out.println("Generated Password: " + strongPassword);
            analyzePassword(strongPassword);
        }
    }

    public static void analyzePassword(String password) {
        int length = password.length();
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if ((int) ch >= 65 && (int) ch <= 90) hasUpper = true;
            else if ((int) ch >= 97 && (int) ch <= 122) hasLower = true;
            else if ((int) ch >= 48 && (int) ch <= 57) hasDigit = true;
            else hasSpecial = true;
        }

        System.out.println("\n--- Password Analysis ---");
        System.out.println("Length: " + length);
        System.out.println("Contains Uppercase: " + hasUpper);
        System.out.println("Contains Lowercase: " + hasLower);
        System.out.println("Contains Digit: " + hasDigit);
        System.out.println("Contains Special Character: " + hasSpecial);

        int score = 0;
        if (length >= 8) score++;
        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSpecial) score++;

        String strength = switch (score) {
            case 5 -> "Very Strong";
            case 4 -> "Strong";
            case 3 -> "Moderate";
            case 2 -> "Weak";
            default -> "Very Weak";
        };

        System.out.println("Strength: " + strength);
    }

    public static String generateStrongPassword(int length) {
        if (length < 8) length = 8;

        Random rand = new Random();
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String special = "!@#$%^&*()-_=+[]{};:,.<>?/";

        StringBuilder password = new StringBuilder();

        password.append(upper.charAt(rand.nextInt(upper.length())));
        password.append(lower.charAt(rand.nextInt(lower.length())));
        password.append(digits.charAt(rand.nextInt(digits.length())));
        password.append(special.charAt(rand.nextInt(special.length())));

        String allChars = upper + lower + digits + special;
        for (int i = 4; i < length; i++) {
            password.append(allChars.charAt(rand.nextInt(allChars.length())));
        }

        List<Character> chars = new ArrayList<>();
        for (char ch : password.toString().toCharArray()) chars.add(ch);
        Collections.shuffle(chars);

        StringBuilder finalPassword = new StringBuilder();
        for (char ch : chars) finalPassword.append(ch);

        return finalPassword.toString();
    }
}
