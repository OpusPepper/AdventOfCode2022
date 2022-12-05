package dev.opuspepper.AdventOfCodeDay5.objects;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class CrateStack {
    protected String crateStack;
    public ArrayList<Character> itemsInCrate = new ArrayList<>();
    protected Integer crateNumber;

    public String getCrateStack() {
        return crateStack;
    }

    public void setCrateStack(String crateStack) {
        this.crateStack = crateStack;
    }

    public Integer getCrateNumber() {
        return crateNumber;
    }

    public void setCrateNumber(Integer crateNumber) {
        this.crateNumber = crateNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Crate #" + crateNumber + ": ");
        for (Character c:itemsInCrate
             ) {
            sb.append(c + ", ");
        }
        return sb.toString().substring(0, (sb.length() - 2));
    }
}
