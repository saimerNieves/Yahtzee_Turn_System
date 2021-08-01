package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Yahtzee {
    //    public Cup myCup = new Cup();
    public Player player;
    private final Scanner scanner = new Scanner(System.in);
    public static int totalGamePoints = 0;

    public Yahtzee() {
        System.out.println("What is your name?");
        player = new Player((scanner.nextLine()).trim());
    }

    // TODO refactor play to run 5 turns then display total score.
    public void play() {
        for (int i = 0; i < 5; i++) {
            turn();
        }
        System.out.println("Total Game POINTS: " + totalGamePoints);
    }

    public void getSelections() {
        System.out.println("select dice you want to re-roll (1-5)");
        String input = scanner.nextLine(); // "1 2 5"
        player.cup.rollMultipleDice((ArrayList<Integer>) player.cup.parseSelections(input));
    }

    // TODO refactor turn to update score and display round score *(and total score)
    public void turn() {
        player.cup.rollAllDiceInCup();

        for (int i = 0; i < 2; i++) {
            System.out.println(player.cup.displayAllDice());
            getSelections();
        }

        System.out.println(player.cup.displayAllDice());

        String[] scoreList = player.cup.displayAllDice().split(" ");

        int roundScoreForTurn = 0;
        for (int i = 0; i < scoreList.length; i++) {

            roundScoreForTurn += Integer.parseInt(scoreList[i]);

        }
        totalGamePoints+= roundScoreForTurn;
        System.out.println("Your Total Round Points: " + roundScoreForTurn);
    }

}