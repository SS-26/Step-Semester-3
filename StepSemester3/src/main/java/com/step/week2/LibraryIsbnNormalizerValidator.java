package com.step.week2;

import java.util.Scanner;

public class LibraryIsbnNormalizerValidator {

    public static String normalizeCode(String rawCode) {
        String trimmedCode = rawCode.trim();

        if (trimmedCode.length() < 3) {
            return trimmedCode.toUpperCase();
        }

        String publisherCode = trimmedCode.substring(0, 3).toUpperCase();
        String remainingCode = trimmedCode.substring(3);

        return publisherCode + remainingCode;
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int index = 0; index < 3; index++) {
            if (!Character.isLetter(code.charAt(index))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int index = 3; index < code.length(); index++) {
            if (!Character.isDigit(code.charAt(index))) {
                return "Invalid: body must contain only digits";
            }
        }

        String publisherCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalogNumber = code.substring(7, 13);

        StringBuilder result = new StringBuilder();

        result.append("[")
                .append(publisherCode)
                .append("] YEAR: ")
                .append(year)
                .append(" | CATALOG: ")
                .append(catalogNumber);

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter ISBN-style code: ");
            String rawCode = scanner.nextLine();

            String normalizedCode = normalizeCode(rawCode);
            String result = validateAndFormat(normalizedCode);

            System.out.println(result);
        } finally {
            scanner.close();
        }
    }
}
