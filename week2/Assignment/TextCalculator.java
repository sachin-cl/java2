package week2.Assignment;

import java.util.Scanner;

public class TextCalculator {

    public static double evaluate(String expression) {
        expression = expression.replaceAll(" ", "");
        return evaluateExpression(expression);
    }

    private static double evaluateExpression(String expr) {
        int open = expr.lastIndexOf('(');
        while (open != -1) {
            int close = expr.indexOf(')', open);
            String subExpr = expr.substring(open + 1, close);
            double value = evaluateExpression(subExpr);
            expr = expr.substring(0, open) + value + expr.substring(close + 1);
            open = expr.lastIndexOf('(');
        }

        return compute(expr);
    }

    private static double compute(String expr) {
        expr = handleMinus(expr);
        expr = computeMulDiv(expr);
        return computeAddSub(expr);
    }

    private static String handleMinus(String expr) {
        if (expr.startsWith("-")) expr = "0" + expr;
        expr = expr.replace("(-", "(0-");
        return expr;
    }

    private static String computeMulDiv(String expr) {
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c == '*' || c == '/') {
                int leftStart = i - 1;
                while (leftStart >= 0 && (Character.isDigit(expr.charAt(leftStart)) || expr.charAt(leftStart) == '.')) leftStart--;
                String left = expr.substring(leftStart + 1, i);

                int rightEnd = i + 1;
                while (rightEnd < expr.length() && (Character.isDigit(expr.charAt(rightEnd)) || expr.charAt(rightEnd) == '.')) rightEnd++;
                String right = expr.substring(i + 1, rightEnd);

                double l = Double.parseDouble(left);
                double r = Double.parseDouble(right);
                double res = (c == '*') ? (l * r) : (l / r);

                expr = expr.substring(0, leftStart + 1) + res + expr.substring(rightEnd);
                i = -1;
            }
        }
        return expr;
    }

    private static double computeAddSub(String expr) {
        double result = 0;
        String num = "";
        char sign = '+';

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                num += c;
            } else {
                double n = Double.parseDouble(num);
                result = apply(result, n, sign);
                sign = c;
                num = "";
            }
        }

        if (!num.isEmpty()) {
            double n = Double.parseDouble(num);
            result = apply(result, n, sign);
        }

        return result;
    }

    private static double apply(double a, double b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        return b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double result = evaluate(input);
        System.out.println("Result: " + result);
    }
}

