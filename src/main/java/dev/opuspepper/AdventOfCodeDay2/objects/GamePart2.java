package dev.opuspepper.AdventOfCodeDay2.objects;

public class GamePart2 {

    protected Move move1;
    protected Move move2;
    protected Move move2Modified;
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

    public GamePart2(Move inMove1, Move inMove2) {
        move1 = inMove1;
        move2 = inMove2;
    }

    public int play() {
        if (move2.isNeedsTie())
        {
            move2Modified = new Move(move1.getMoveType(), move1.getMoveValue(), move2.getMoveNumber());
            move2 = move2Modified;
        }
        else if (move2.isNeedsLose())
        {
            move2Modified = getLosingMove(move1);
            move2 = move2Modified;
        }
        else if (move2.isNeedsWin())
        {
            move2Modified = getWinningMove(move1);
            move2 = move2Modified;
        }

        if ((move1.isRock() && move2.isScissors()) ||
                        (move1.isScissors() && move2.isPaper()) ||
                        (move1.isPaper() && move2.isRock()))
            winner = move1.moveNumber;
        else if ((move2.isRock() && move1.isScissors()) ||
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

    private Move getLosingMove(Move winningMove)
    {
        if (winningMove.isRock())
        {
            return new Move("scissors", Character.valueOf('C'), 2);
        }
        if (winningMove.isPaper())
        {
            return new Move("rock", Character.valueOf('A'), 2);
        }
        if (winningMove.isScissors())
        {
            return new Move("paper", Character.valueOf('B'), 2);
        }
        return null;
    }
    private Move getWinningMove(Move losingMove)
    {
        if (losingMove.isRock())
        {
            return new Move("paper", Character.valueOf('B'), 2);
        }
        if (losingMove.isPaper())
        {
            return new Move("scissors", Character.valueOf('C'), 2);
        }
        if (losingMove.isScissors())
        {
            return new Move("rock", Character.valueOf('A'), 2);
        }
        return null;
    }
}
