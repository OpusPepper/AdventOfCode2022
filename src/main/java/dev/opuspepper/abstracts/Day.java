package dev.opuspepper.abstracts;

import dev.opuspepper.helper.FileReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class Day {
    protected int day;
    public abstract void getDay();

    public abstract void part1(List<String> recordsIn, String inputLabel);
    public abstract void part2(List<String> recordsIn, String inputLabel);


}
