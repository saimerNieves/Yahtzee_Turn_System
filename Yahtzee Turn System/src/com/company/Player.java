package com.company;

public class Player {

    //Member Data
    public String playerName;
    public Cup cup = new Cup();
    public int score = 0;

    //Member Constructor
    public Player(String newPlayerName){

        playerName = newPlayerName;
    }

    //Member Behavior
    public int updateScore(){
        int scoreInRound = 0;

        for (Die oneDieInCup : cup.collectionOfDice){

            scoreInRound += oneDieInCup.faceUpValue;
        }

        score+= scoreInRound;
        return scoreInRound;
    }

}
