package com.step.week1.practiceweek1;

import java.util.Scanner;

public class PalindromeChecker {

    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        return checkRecursive(text, 0, text.length() - 1);
    }

    private static boolean checkRecursive(String text, int left, int right) {
        if (left >= right) {
            return true;
        }

        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }

        return checkRecursive(text, left + 1, right - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] originalCharacters = text.toCharArray();
        char[] reversedCharacters = new char[originalCharacters.length];

        for (int index = 0; index < originalCharacters.length; index++) {
            reversedCharacters[index] =
                    originalCharacters[originalCharacters.length - 1 - index];
        }

        return new String(originalCharacters).equals(new String(reversedCharacters));
    }

    public static String getResult(boolean isPalindrome) {
        return isPalindrome ? "Palindrome" : "Not Palindrome";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word or phrase: ");
        String text = scanner.nextLine();

        boolean iterativeResult = isPalindromeIterative(text);
        boolean recursiveResult = isPalindromeRecursive(text);
        boolean arrayResult = isPalindromeArrayReversal(text);

        System.out.println("Iterative: " + getResult(iterativeResult)
                + " | Recursive: " + getResult(recursiveResult)
                + " | Array Reversal: " + getResult(arrayResult));

        scanner.close();
    }
}
