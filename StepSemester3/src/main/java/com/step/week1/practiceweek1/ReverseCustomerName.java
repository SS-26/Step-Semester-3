
package com.step.week1.practiceweek1;

import java.util.Scanner;

public class ReverseCustomerName {

    public static String reverseCustomerName(String customerName) {
        char[] characters = customerName.toCharArray();
        StringBuilder reversedName = new StringBuilder();

        for (int index = characters.length - 1; index >= 0; index--) {
            reversedName.append(characters[index]);
        }

        return reversedName.toString();
    }

    public static void printNames(String customerName) {
        String reversedName = reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        if (customerName.trim().isEmpty()) {
            System.out.println("Customer name cannot be empty.");
        } else {
            printNames(customerName);
        }

        scanner.close();
    }
}
