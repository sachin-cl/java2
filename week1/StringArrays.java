
public class StringArrays{
    public static String findLongestName(String[] names) {
        if (names == null || names.length == 0) {
            return null;
        }

        String longestName = names[0];
        for (String name : names) {
            if (name.length() > longestName.length()) {
                longestName = name;
            }
        }
        return longestName;
    }

    // Counts how many names start with a given letter (case-insensitive)
    public static int countNamesStartingWith(String[] names, char letter) {
        if (names == null) {
            return 0;
        }
        int count = 0;
        char lowerCaseLetter = Character.toLowerCase(letter);
        for (String name : names) {
            if (name != null && !name.isEmpty()) {
                if (Character.toLowerCase(name.charAt(0)) == lowerCaseLetter) {
                    count++;
                }
            }
        }
        return count;
    }

    // Formats names from "First Last" to "Last, First"
    public static String[] formatNames(String[] names) {
        if (names == null) {
            return new String[0];
        }

        String[] formattedNames = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (name != null && name.contains(" ")) {
                int spaceIndex = name.lastIndexOf(" ");
                String firstName = name.substring(0, spaceIndex);
                String lastName = name.substring(spaceIndex + 1);
                formattedNames[i] = lastName + ", " + firstName;
            } else {
                formattedNames[i] = name;
            }
        }
        return formattedNames;
    }

    public static void main(String[] args) {
        String[] students = {"John Smith", "Alice Johnson", "Bob Brown", "Carol Davis", "David Wilson"};

        // Test the methods and display results
        System.out.println("Original Names:");
        for (String name : students) {
            System.out.println("- " + name);
        }

        // Test findLongestName
        String longestName = findLongestName(students);
        System.out.println("\nLongest Name: " + longestName);

        // Test countNamesStartingWith
        int countB = countNamesStartingWith(students, 'B');
        System.out.println("Names starting with 'B': " + countB);

        // Test formatNames
        String[] formattedStudents = formatNames(students);
        System.out.println("\nFormatted Names (Last, First):");
        for (String name : formattedStudents) {
            System.out.println("- " + name);
        }
    }
}

    

