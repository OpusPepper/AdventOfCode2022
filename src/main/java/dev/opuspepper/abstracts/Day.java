package dev.opuspepper.abstracts;

import java.io.File;

public abstract class Day {
    protected int day;
    public abstract void getDay();

    public abstract void part1(File inputFile, String inputLabel);
    public abstract void part2(File inputFile, String inputLabel);
}
