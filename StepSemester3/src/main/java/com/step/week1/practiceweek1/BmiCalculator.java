package com.step.week1.practiceweek1;

import java.util.Scanner;

public class BmiCalculator {

    public static double calculateBmi(double height, double weight) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than zero.");
        }

        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than zero.");
        }

        return weight / (height * height);
    }

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("\nWellness Report");
        System.out.println("----------------------------------------------------------");
        System.out.printf("%-10s %-15s %-15s %-10s %-15s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("----------------------------------------------------------");

        for (int index = 0; index < heights.length; index++) {
            try {
                double bmi = calculateBmi(heights[index], weights[index]);
                String status = getBmiStatus(bmi);

                System.out.printf("%-10d %-15.2f %-15.2f %-10.2f %-15s%n",
                        index + 1, heights[index], weights[index], bmi, status);

            } catch (IllegalArgumentException exception) {
                System.out.println("Invalid data for Person " + (index + 1)
                        + ": " + exception.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = 2;
        double[] heights = new double[numberOfPeople];
        double[] weights = new double[numberOfPeople];

        try {
            for (int index = 0; index < numberOfPeople; index++) {
                System.out.print("Enter height for Person " + (index + 1) + " in meters: ");
                heights[index] = Double.parseDouble(scanner.nextLine());

                System.out.print("Enter weight for Person " + (index + 1) + " in kg: ");
                weights[index] = Double.parseDouble(scanner.nextLine());
            }

            printWellnessReport(heights, weights);

        } catch (NumberFormatException exception) {
            System.out.println("Invalid input. Please enter numeric values.");

        } finally {
            scanner.close();
        }
    }
}
