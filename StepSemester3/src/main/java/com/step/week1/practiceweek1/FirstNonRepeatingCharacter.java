package com.step.week1.practiceweek1;

import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    public static char findFirstNonRepeatingChar(String text) {
        for (int currentIndex = 0; currentIndex < text.length(); currentIndex++) {
            char currentCharacter = text.charAt(currentIndex);
            int frequency = 0;

            for (int index = 0; index < text.length(); index++) {
                if (text.charAt(index) == currentCharacter) {
                    frequency++;
                }
            }

            if (frequency == 1) {
                return currentCharacter;
            }
        }

        return '\0';
    }

    public static void printResult(String text) {
        char result = findFirstNonRepeatingChar(text);

        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("First Non-Repeating Character: '" + result + "'");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word or sentence: ");
        String text = scanner.nextLine();

        printResult(text);

        scanner.close();
    }
}
