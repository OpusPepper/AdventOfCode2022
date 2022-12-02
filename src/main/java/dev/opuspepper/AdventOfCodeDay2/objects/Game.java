package dev.opuspepper.AdventOfCodeDay2.objects;

public class Game {

    protected Move move1;
    protected Move move2;
    protected int score;
    protected int winner;

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    protected int player1Score;
    protected int player2Score;

    public Game(Move inMove1, Move inMove2) {
        move1 = inMove1;
        move2 = inMove2;
    }

    public int play() {
        if (
                (move1.isRock() && move2.isScissors()) ||
                        (move1.isScissors() && move2.isPaper()) ||
                        (move1.isPaper() && move2.isRock()))
            winner = move1.moveNumber;
        else if (
                (move2.isRock() && move1.isScissors()) ||
                        (move2.isScissors() && move1.isPaper()) ||
                        (move2.isPaper() && move1.isRock()))
            winner = move2.moveNumber;
        else
            winner = 0; // tie

        score();
        return winner;
    }

    private void score() {
        player1Score = 0;
        // calculate player 1 score;
        if (move1.isRock())
            player1Score += 1;
        if (move1.isPaper())
            player1Score += 2;
        if (move1.isScissors())
            player1Score += 3;

        player2Score = 0;
        // calculate player 1 score;
        if (move2.isRock())
            player2Score += 1;
        if (move2.isPaper())
            player2Score += 2;
        if (move2.isScissors())
            player2Score += 3;

        if (winner == 1)
            player1Score += 6;
        if (winner == 2)
            player2Score += 6;
        if (winner == 0) {
            player1Score += 3;
            player2Score += 3;
        }
    }

}
