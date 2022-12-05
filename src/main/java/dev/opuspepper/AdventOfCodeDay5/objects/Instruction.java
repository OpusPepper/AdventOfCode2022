package dev.opuspepper.AdventOfCodeDay5.objects;

import java.util.ArrayList;

public class Instruction {
    protected Integer numberOfCratesToMove;
    protected Integer fromCrateStack;
    protected Integer toCrateStack;
    protected String instruction;

    public Instruction(String instruction) {
        this.instruction = instruction;

        Integer instructionNumber = 0;
        for (String s:instruction.split(" ")
             ) {
            try {
                Integer extractedNumber = Integer.valueOf(s.trim());
                instructionNumber++;

                switch (instructionNumber) {
                    case 1 -> numberOfCratesToMove = extractedNumber;
                    case 2 -> fromCrateStack = extractedNumber;
                    case 3 -> toCrateStack = extractedNumber;
                }

            } catch (NumberFormatException e) {
                continue;  // i.e. it wasn't a number
            }
        }
    }

    public Integer getNumberOfCratesToMove() {
        return numberOfCratesToMove;
    }

    public void setNumberOfCratesToMove(Integer numberOfCratesToMove) {
        this.numberOfCratesToMove = numberOfCratesToMove;
    }

    public Integer getFromCrateStack() {
        return fromCrateStack;
    }

    public void setFromCrateStack(Integer fromCrateStack) {
        this.fromCrateStack = fromCrateStack;
    }

    public Integer getToCrateStack() {
        return toCrateStack;
    }

    public void setToCrateStack(Integer toCrateStack) {
        this.toCrateStack = toCrateStack;
    }
}
