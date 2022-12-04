package dev.opuspepper.AdventOfCodeDay3;

import dev.opuspepper.AdventOfCodeDay2.objects.Game;
import dev.opuspepper.AdventOfCodeDay2.objects.GamePart2;
import dev.opuspepper.AdventOfCodeDay2.objects.Move;
import dev.opuspepper.AdventOfCodeDay3.objects.Rucksack;
import dev.opuspepper.AdventOfCodeDay3.objects.RucksackGroup;
import dev.opuspepper.abstracts.Day;
import dev.opuspepper.abstracts.DayOrig;
import dev.opuspepper.helper.FileReader;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day3 extends Day {
    public void getDay()
    {
        day = 3;
    }
    public void part1(List<String> recordsIn, String inputLabel)
    {
        System.out.println("Starting " + inputLabel);

        ArrayList<Integer> listOfPrioritySums = new ArrayList<Integer>();

        for (String s : recordsIn
             ) {
            Rucksack newRucksack = new Rucksack(s);
            System.out.println("String = '" + s + "'");
            System.out.println("Sack1 = '" + newRucksack.getSack1() + "'");
            System.out.println("Sack2 = '" + newRucksack.getSack2() + "'");
            System.out.println("Same in both: " + newRucksack.getCharactersInBothSacks());

            System.out.println("Sum of priorities for '" + s + "' is " + newRucksack.getSumOfPriorities());
            listOfPrioritySums.add(newRucksack.getSumOfPriorities());
        }
        Integer sumOfSums = 0;
        for (Integer i : listOfPrioritySums
             ) {
            sumOfSums += i;
        }
        System.out.println("Sum of sums of priorities = " + sumOfSums);

        System.out.println("Ending " + inputLabel);
    }

    public void part2(List<String> recordsIn, String inputLabel) {
        System.out.println("Starting " + inputLabel);

        ArrayList<Integer> listOfPrioritySums = new ArrayList<Integer>();

        Integer rucksackGroupCounter = 0;
        RucksackGroup rucksackGroup = new RucksackGroup();
        ArrayList<RucksackGroup> rucksackGroups = new ArrayList<RucksackGroup>();
        for (String s : recordsIn
        ) {
            Rucksack newRucksack = new Rucksack(s);
            System.out.println("String = '" + s + "'");
            System.out.println("Sack1 = '" + newRucksack.getSack1() + "'");
            System.out.println("Sack2 = '" + newRucksack.getSack2() + "'");
            System.out.println("Same in both: " + newRucksack.getCharactersInBothSacks());

            System.out.println("Sum of priorities for '" + s + "' is " + newRucksack.getSumOfPriorities());
            listOfPrioritySums.add(newRucksack.getSumOfPriorities());

            // Deal with groups
            rucksackGroup.groupRucksacks.add(newRucksack);
            rucksackGroupCounter = rucksackGroupCounter == 2 ? 0 : (rucksackGroupCounter + 1);
            if (rucksackGroupCounter == 0)
            {
                rucksackGroup.findBadge();
                rucksackGroups.add(rucksackGroup);
                rucksackGroup = new RucksackGroup();
            }
        }
        Integer sumOfBadgeValues = 0;
        for (RucksackGroup rsg : rucksackGroups
        ) {
            sumOfBadgeValues += rsg.getPriorityValueOfBadge();
        }
        System.out.println("Sum of badge priorities = " + sumOfBadgeValues);

        System.out.println("Ending " + inputLabel);
    }


    }
