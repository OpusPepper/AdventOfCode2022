package dev.opuspepper.AdventOfCodeDay1;

import dev.opuspepper.abstracts.Day;
import dev.opuspepper.helper.FileReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1 extends Day {
    public void getDay()
    {
        day = 1;
    }
    public void part1(File inputFile, String inputLabel)
    {
        //File inputFile = new File("C:\\Users\\CPJSa\\GitHub\\OpusPepper\\AdventOfCode2022\\src\\main\\resources\\Day1Part1Example.txt");
        System.out.println("Starting " + inputLabel);
        FileReader fileReader = new FileReader();

        List<String> recordsIn = fileReader.readFile(inputFile);
        ArrayList<Integer> totalCalories = new ArrayList<>();
        Integer totalTemp = 0;
        for (String s: recordsIn) {
            if (s.length() == 0)
            {
                totalCalories.add(totalTemp);
                totalTemp = 0;
            }
            else {
                totalTemp += Integer.parseInt(s);
            }
        }
        if (totalTemp != 0) // Account for last entry
        {
            totalCalories.add(totalTemp);
        }
        for (Integer i: totalCalories
             ) {
            System.out.println("Elf had " + i + " calories");
        }
        Integer max = 0;
        Integer elf = 0;
        for (int i = 0; i < totalCalories.size(); i++ )
        {
            if (totalCalories.get(i) > max)
            {
                max = totalCalories.get(i);
                elf = i;
            }
        }
        if (max != 0 && elf != 0)
        System.out.println("Elf " + elf + " had the most calories at " + max);
        else
            System.out.println("No fat elf found!");

        System.out.println("Ending " + inputLabel);
    }

    public void part2(File inputFile, String inputLabel)
    {
        //File inputFile = new File("C:\\Users\\CPJSa\\GitHub\\OpusPepper\\AdventOfCode2022\\src\\main\\resources\\Day1Part1Example.txt");
        System.out.println("Starting " + inputLabel);
        FileReader fileReader = new FileReader();

        List<String> recordsIn = fileReader.readFile(inputFile);
        ArrayList<Integer> totalCalories = new ArrayList<>();
        Integer totalTemp = 0;
        for (String s: recordsIn) {
            //System.out.println("Line = " + s);
            if (s.length() == 0)
            {
                totalCalories.add(totalTemp);
                totalTemp = 0;
            }
            else {
                totalTemp += Integer.parseInt(s);
            }
        }
        if (totalTemp != 0) // Account for last entry
        {
            totalCalories.add(totalTemp);
        }
        for (Integer i: totalCalories
        ) {
            System.out.println("Elf had " + i + " calories");
        }
        Collections.sort(totalCalories, Collections.reverseOrder());

        Integer totalTop3 = 0;
        Integer elf = 0;
        System.out.println("Top 3 elves ");
        for (int i = 0; i < 3; i++ )
        {
            System.out.println("Elf " + (i + 1) + " had this many calories: " + totalCalories.get(i));
            totalTop3 += totalCalories.get(i);
        }
        System.out.println();
        System.out.println("Top 3 elves had a total of " + totalTop3 + " calories.");

        System.out.println("Ending " + inputLabel);
    }
}
