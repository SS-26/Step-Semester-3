package com.step.week1.practiceweek1;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors"))
                || (playerMove.equals("Paper") && computerMove.equals("Rock"))
                || (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static String generateComputerMove(Random random) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        int randomIndex = random.nextInt(moves.length);
        return moves[randomIndex];
    }

    public static String formatMove(String move) {
        if (move.equalsIgnoreCase("rock")) {
            return "Rock";
        } else if (move.equalsIgnoreCase("paper")) {
            return "Paper";
        } else if (move.equalsIgnoreCase("scissors")) {
            return "Scissors";
        }

        return "";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberOfRounds = 5;
        int wins = 0;
        int losses = 0;
        int draws = 0;

        String[] playerMoves = new String[numberOfRounds];
        String[] computerMoves = new String[numberOfRounds];
        String[] results = new String[numberOfRounds];

        for (int round = 0; round < numberOfRounds; round++) {
            System.out.print("Enter your move (Rock, Paper, or Scissors): ");
            String playerMove = formatMove(scanner.nextLine());

            while (playerMove.isEmpty()) {
                System.out.println("Invalid move. Please enter Rock, Paper, or Scissors.");
                System.out.print("Enter your move: ");
                playerMove = formatMove(scanner.nextLine());
            }

            String computerMove = generateComputerMove(random);
            String result = playRound(playerMove, computerMove);

            playerMoves[round] = playerMove;
            computerMoves[round] = computerMove;
            results[round] = result;

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        System.out.println("\nFinal Summary");
        System.out.println("------------------------------------------------");
        System.out.printf("%-8s %-15s %-15s %-15s%n",
                "Round", "Player Move", "Computer Move", "Result");
        System.out.println("------------------------------------------------");

        for (int round = 0; round < numberOfRounds; round++) {
            System.out.printf("%-8d %-15s %-15s %-15s%n",
                    round + 1, playerMoves[round], computerMoves[round], results[round]);
        }

        double winPercentage = (double) wins / numberOfRounds * 100;

        System.out.println("\nWins: " + wins
                + " | Losses: " + losses
                + " | Draws: " + draws
                + " | Win % = " + winPercentage + "%");

        scanner.close();
    }
}
