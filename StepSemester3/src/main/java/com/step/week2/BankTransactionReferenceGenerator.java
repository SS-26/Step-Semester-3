package com.step.week2;

import java.util.Scanner;

public class BankTransactionReferenceGenerator {

    public static String normalizeReference(String rawReference) {
        String trimmedReference = rawReference.trim();

        if (trimmedReference.length() < 3) {
            return trimmedReference.toUpperCase();
        }

        String bankCode = trimmedReference.substring(0, 3).toUpperCase();
        String remainingPart = trimmedReference.substring(3);

        return bankCode + remainingPart;
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        for (int index = 0; index < 3; index++) {
            if (!Character.isLetter(reference.charAt(index))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int index = 3; index < reference.length(); index++) {
            if (!Character.isDigit(reference.charAt(index))) {
                return "Invalid: body must contain only digits";
            }
        }

        String bankCode = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String sequenceNumber = reference.substring(9, 14);

        String formattedDate = date.substring(0, 2)
                + "/" + date.substring(2, 4)
                + "/" + date.substring(4, 6);

        StringBuilder formattedReference = new StringBuilder();
        formattedReference.append("[")
                .append(bankCode)
                .append("] DATE: ")
                .append(formattedDate)
                .append(" | SEQ: ")
                .append(sequenceNumber);

        return formattedReference.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter transaction reference: ");
            String rawReference = scanner.nextLine();

            String normalizedReference = normalizeReference(rawReference);
            String result = validateAndFormat(normalizedReference);

            System.out.println(result);

        } finally {
            scanner.close();
        }
    }
}
