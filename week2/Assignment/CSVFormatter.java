package week2.Assignment;

import java.util.*;

public class CSVFormatter {

    public static String formatCSV(String csvText) {
        String[] rows = csvText.split("\n");
        List<String[]> data = new ArrayList<>();
        int columnCount = 0;

        for (String row : rows) {
            String[] columns = row.split(",");
            data.add(columns);
            if (columns.length > columnCount) columnCount = columns.length;
        }

        int[] columnWidths = new int[columnCount];
        for (String[] row : data) {
            for (int i = 0; i < row.length; i++) {
                String value = row[i].trim();
                if (value.length() > columnWidths[i]) {
                    columnWidths[i] = value.length();
                }
            }
        }

        StringBuilder output = new StringBuilder();
        for (String[] row : data) {
            for (int i = 0; i < columnCount; i++) {
                String value = (i < row.length) ? row[i].trim() : "";
                output.append(padRight(value, columnWidths[i] + 2));
            }
            output.append("\n");
        }

        return output.toString();
    }

    private static String padRight(String text, int length) {
        while (text.length() < length) {
            text += " ";
        }
        return text;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) break;
            input.append(line).append("\n");
        }

        String formatted = formatCSV(input.toString().trim());
        System.out.println("Formatted Table:\n");
        System.out.println(formatted);
    }
}
