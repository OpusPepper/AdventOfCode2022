package dev.opuspepper.AdventOfCodeDay2;

import dev.opuspepper.AdventOfCodeDay2.objects.Game;
import dev.opuspepper.AdventOfCodeDay2.objects.GamePart2;
import dev.opuspepper.AdventOfCodeDay2.objects.Move;
import dev.opuspepper.abstracts.Day;
import dev.opuspepper.abstracts.DayOrig;
import dev.opuspepper.helper.FileReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day2 extends Day {
    public void getDay()
    {
        day = 2;
    }
    public void part1(List<String> recordsIn, String inputLabel)
    {
        //File inputFile = new File("C:\\Users\\CPJSa\\GitHub\\OpusPepper\\AdventOfCode2022\\src\\main\\resources\\Day1Part1Example.txt");
        System.out.println("Starting " + inputLabel);

        int player1Score = 0;
        int player2Score = 0;
        for (String s:recordsIn) {
            String s1 = s.split(" ")[0];
            String s2 = s.split(" ")[1];

            //System.out.println("s1 = " + s1);
            //System.out.println("s2 = " + s2);

            Move move1 = generateMove(s1, 1);
            Move move2 = generateMove(s2, 2);

            Game game = new Game(move1, move2);
            int winner = game.play();
            //System.out.println("Winner: " + winner);
            player1Score += game.getPlayer1Score();
            player2Score += game.getPlayer2Score();
        }

        System.out.println("Player 1 score: " + player1Score);
        System.out.println("Player 2 score: " + player2Score);

        System.out.println("Ending " + inputLabel);
    }

    public void part2(List<String> recordsIn, String inputLabel)
    {
        //File inputFile = new File("C:\\Users\\CPJSa\\GitHub\\OpusPepper\\AdventOfCode2022\\src\\main\\resources\\Day1Part1Example.txt");
        System.out.println("Starting " + inputLabel);

        int player1Score = 0;
        int player2Score = 0;
        for (String s:recordsIn) {
            String s1 = s.split(" ")[0];
            String s2 = s.split(" ")[1];

            //System.out.println("s1 = " + s1);
            //System.out.println("s2 = " + s2);

            Move move1 = generateMovePart2(s1, 1);
            Move move2 = generateMovePart2(s2, 2);

            GamePart2 game = new GamePart2(move1, move2);
            int winner = game.play();
            //System.out.println("Winner: " + winner);
            player1Score += game.getPlayer1Score();
            player2Score += game.getPlayer2Score();
        }

        System.out.println("Player 1 score: " + player1Score);
        System.out.println("Player 2 score: " + player2Score);

        System.out.println("Ending " + inputLabel);
    }

    private Move generateMove(String s1, int moveNumber){
        String moveType = "";
        if (s1.equalsIgnoreCase("A") || s1.equalsIgnoreCase("X"))
            moveType = "rock";
        else if (s1.equalsIgnoreCase("B") || s1.equalsIgnoreCase("Y"))
            moveType = "paper";
        else if (s1.equalsIgnoreCase("C") || s1.equalsIgnoreCase("Z"))
            moveType = "scissors";
        return new Move(moveType, s1.toCharArray()[0], moveNumber);
    }

    private Move generateMovePart2(String s1, int moveNumber){
        String moveType = "";
        if (moveNumber == 1) {
            if (s1.equalsIgnoreCase("A"))
                moveType = "rock";
            else if (s1.equalsIgnoreCase("B"))
                moveType = "paper";
            else if (s1.equalsIgnoreCase("C"))
                moveType = "scissors";
        }
        if (moveNumber == 2) {
            if (s1.equalsIgnoreCase("X"))
                moveType = "lose";
            else if (s1.equalsIgnoreCase("Y"))
                moveType = "tie";
            else if (s1.equalsIgnoreCase("Z"))
                moveType = "win";
        }

        return new Move(moveType, s1.toCharArray()[0], moveNumber);
    }
}
