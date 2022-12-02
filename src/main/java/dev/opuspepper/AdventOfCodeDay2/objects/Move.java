package dev.opuspepper.AdventOfCodeDay2.objects;

import java.util.ArrayList;

public class Move {
    public Move(String moveType, Character moveValue, int moveNumber) {
        this.moveType = moveType;
        this.moveValue = moveValue;
        this.moveNumber = moveNumber;
    }

    public String getMoveType() {
        return moveType;
    }

    public void setMoveType(String moveType) {
        this.moveType = moveType;
    }

    public int getPointValue() {
        return pointValue;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    protected String moveType;

    protected int pointValue;

    public Character getMoveValue() {
        return moveValue;
    }

    public void setMoveValue(Character moveValue) {
        this.moveValue = moveValue;
    }

    protected Character moveValue;

    public int getMoveNumber() {
        return moveNumber;
    }

    public void setMoveNumber(int moveNumber) {
        this.moveNumber = moveNumber;
    }

    protected int moveNumber;

    public Boolean isRock()
    {
        if (moveType == "rock")
            return true;
        return false;
    }

    public Boolean isPaper()
    {
        if (moveType == "paper")
            return true;
        return false;
    }

    public Boolean isScissors()
    {
        if (moveType == "scissors")
            return true;
        return false;
    }

    public Boolean isNeedsWin()
    {
        if (moveType == "win")
            return true;
        return false;
    }

    public Boolean isNeedsLose()
    {
        if (moveType == "lose")
            return true;
        return false;
    }

    public Boolean isNeedsTie()
    {
        if (moveType == "tie")
            return true;
        return false;
    }
}
