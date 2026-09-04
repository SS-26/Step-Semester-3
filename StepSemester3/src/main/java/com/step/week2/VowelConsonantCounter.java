package com.step.week2;

import java.util.Scanner;

public class VowelConsonantCounter {

    public static void countVowelsAndConsonants(String text) {
        int vowelCount = 0;
        int consonantCount = 0;

        for (int index = 0; index < text.length(); index++) {
            char currentCharacter = Character.toLowerCase(text.charAt(index));

            if (currentCharacter == 'a' || currentCharacter == 'e'
                    || currentCharacter == 'i' || currentCharacter == 'o'
                    || currentCharacter == 'u') {
                vowelCount++;
            } else if (currentCharacter >= 'a' && currentCharacter <= 'z') {
                consonantCount++;
            }
        }

        System.out.println("Vowels: " + vowelCount
                + " | Consonants: " + consonantCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter a book title: ");
            String title = scanner.nextLine();

            countVowelsAndConsonants(title);

        } finally {
            scanner.close();
        }
    }
}
