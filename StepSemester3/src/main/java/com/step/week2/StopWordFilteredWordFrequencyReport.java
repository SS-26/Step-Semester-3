package com.step.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StopWordFilteredWordFrequencyReport {

    public static void printFilteredWordFrequency(String feedback) {
        Set<String> stopWords = new HashSet<>(Arrays.asList(
                "the", "was", "and", "a", "is", "of", "in"
        ));

        String cleanedText = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "");

        String[] words = cleanedText.split("\\s+");

        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            if (!stopWords.contains(word) && !word.isEmpty()) {
                wordFrequency.put(
                        word,
                        wordFrequency.getOrDefault(word, 0) + 1
                );
            }
        }

        List<Map.Entry<String, Integer>> sortedEntries =
                new ArrayList<>(wordFrequency.entrySet());

        sortedEntries.sort(
                (firstEntry, secondEntry) ->
                        secondEntry.getValue().compareTo(firstEntry.getValue())
        );

        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter feedback: ");
            String feedback = scanner.nextLine();

            printFilteredWordFrequency(feedback);
        } finally {
            scanner.close();
        }
    }
}