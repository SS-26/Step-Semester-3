package com.step.week2;

import java.util.Scanner;

public class CsvStudentRecordParser {

    public static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String studentName = fields[0].trim();
        String rollNumber = fields[1].trim();
        String department = fields[2].trim();

        System.out.println("Name: " + studentName
                + " | Roll No: " + rollNumber
                + " | Dept: " + department);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter student record (Name,RollNumber,Department): ");
            String csvLine = scanner.nextLine();

            parseStudentRecord(csvLine);

        } finally {
            scanner.close();
        }
    }
}
