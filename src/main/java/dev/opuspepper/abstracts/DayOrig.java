package dev.opuspepper.abstracts;

import java.io.File;

public abstract class DayOrig {
    protected int day;
    public abstract void getDay();

    public abstract void part1(File inputFile, String inputLabel);
    public abstract void part2(File inputFile, String inputLabel);


}
