package com.company;

import java.util.ArrayList;
import java.util.List;

public class Cup {

    //Member Data
    ArrayList<Die> collectionOfDice = new ArrayList<>();
    int totalDiceNeededInYahtzee = 5;

    //Member Constructor
    public Cup(){

        //We are going to create and add the dice into the Cup
        while( collectionOfDice.size() < totalDiceNeededInYahtzee){
            collectionOfDice.add(new Die());
        }
    }

    //Member Behavior
    public void rollAllDiceInCup(){
        //Roll all the Dice in the Cup
        for (Die oneDieInCup : collectionOfDice){
            oneDieInCup.roll();
        }
    }


    public void rollOneDice(int diceSelectedIndex){
        //Allows the user to get one dice and re-roll it while keeping the others intact
        collectionOfDice.get(diceSelectedIndex).roll();
    }


    public void rollMultipleDice(ArrayList<Integer> diceSelectedIndexes){

        for (int oneDieIndex: diceSelectedIndexes) {
            //Calls local method to roll one Die and passes down the selected index
            rollOneDice(oneDieIndex);
        }
    }


    public String displayAllDice(){

        String allDiceDisplay = "";

        for (Die oneDie : collectionOfDice){
            allDiceDisplay += oneDie.faceUpValue + " ";
        }

        return allDiceDisplay.trim();
    }



    public List<Integer> parseSelections(String input) {
        String[] inputArr = input.split(" "); // ["1", "2", "5"]
        // String[] -> List<Integer>
        List<Integer> selections = new ArrayList<>();
        for (String number : inputArr) {
            selections.add(Integer.parseInt(number) - 1);
        }

        return selections.contains(-1) ? new ArrayList<Integer>() : selections;
    }

}
