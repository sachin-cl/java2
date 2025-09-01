package week2.lab;

import java.util.*;

public class EmailAnalyzer {

    static class EmailInfo {
        String email, username, domain, domainName, extension;
        boolean isValid;

        EmailInfo(String email, String username, String domain, String domainName, String extension, boolean isValid) {
            this.email = email;
            this.username = username;
            this.domain = domain;
            this.domainName = domainName;
            this.extension = extension;
            this.isValid = isValid;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<EmailInfo> emailList = new ArrayList<>();

        System.out.println("Enter emails (type 'done' to finish):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) break;
            boolean valid = isValidEmail(input);
            EmailInfo info = extractEmailParts(input, valid);
            emailList.add(info);
        }

        displayEmailTable(emailList);
        analyzeStatistics(emailList);
    }

    public static boolean isValidEmail(String email) {
        int at = email.indexOf('@');
        int lastAt = email.lastIndexOf('@');

        if (at == -1 || at != lastAt) return false;

        int dotAfterAt = email.indexOf('.', at);
        if (dotAfterAt == -1) return false;

        String username = email.substring(0, at);
        String domain = email.substring(at + 1);

        if (username.isEmpty() || domain.isEmpty()) return false;

        return true;
    }

    public static EmailInfo extractEmailParts(String email, boolean isValid) {
        String username = "", domain = "", domainName = "", extension = "";

        if (isValid) {
            int at = email.indexOf('@');
            username = email.substring(0, at);
            domain = email.substring(at + 1);

            int dot = domain.lastIndexOf('.');
            if (dot != -1) {
                domainName = domain.substring(0, dot);
                extension = domain.substring(dot + 1);
            }
        }

        return new EmailInfo(email, username, domain, domainName, extension, isValid);
    }

    public static void displayEmailTable(List<EmailInfo> list) {
        System.out.printf("\n%-30s %-15s %-20s %-20s %-10s %-10s\n", 
            "Email", "Username", "Domain", "Domain Name", "Extension", "Valid?");
        System.out.println("---------------------------------------------------------------------------------------------");
        for (EmailInfo info : list) {
            System.out.printf("%-30s %-15s %-20s %-20s %-10s %-10s\n", 
                info.email, info.username, info.domain, info.domainName, info.extension, info.isValid ? "Yes" : "No");
        }
    }

    public static void analyzeStatistics(List<EmailInfo> list) {
        int validCount = 0, invalidCount = 0, usernameLengthSum = 0;
        Map<String, Integer> domainFrequency = new HashMap<>();

        for (EmailInfo info : list) {
            if (info.isValid) {
                validCount++;
                usernameLengthSum += info.username.length();
                domainFrequency.put(info.domain, domainFrequency.getOrDefault(info.domain, 0) + 1);
            } else {
                invalidCount++;
            }
        }

        String mostCommonDomain = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : domainFrequency.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommonDomain = entry.getKey();
            }
        }

        double averageUsernameLength = validCount > 0 ? (double) usernameLengthSum / validCount : 0;

        System.out.println("\n--- Email Analysis ---");
        System.out.println("Total Emails: " + list.size());
        System.out.println("Valid Emails: " + validCount);
        System.out.println("Invalid Emails: " + invalidCount);
        System.out.println("Most Common Domain: " + (mostCommonDomain.isEmpty() ? "N/A" : mostCommonDomain));
        System.out.printf("Average Username Length: %.2f\n", averageUsernameLength);
    }
}
