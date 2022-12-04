package dev.opuspepper.AdventOfCodeDay4;

import dev.opuspepper.AdventOfCodeDay4.objects.Assignment;
import dev.opuspepper.abstracts.Day;

import java.util.ArrayList;
import java.util.List;

public class Day4 extends Day {
    public void getDay()
    {
        day = 4;
    }
    public void part1(List<String> recordsIn, String inputLabel)
    {
        System.out.println("Starting " + inputLabel);
        ArrayList<String> listOfDuplicatedAssignments = new ArrayList<>();

        for (String s : recordsIn
             ) {
            Assignment assignment1 = new Assignment(s.split(",")[0]);
            Assignment assignment2 = new Assignment(s.split(",")[1]);

            if (assignment1.isFullyContains(assignment2) ||
                assignment2.isFullyContains(assignment1))
            {
                listOfDuplicatedAssignments.add(s);
            }

        }
        System.out.println("Total fully contained assignments: " + listOfDuplicatedAssignments.size());

        System.out.println("Ending " + inputLabel);
    }

    public void part2(List<String> recordsIn, String inputLabel) {
        System.out.println("Starting " + inputLabel);
        ArrayList<String> listOfAnyDuplicatedAssignments = new ArrayList<>();

        for (String s : recordsIn
        ) {
            Assignment assignment1 = new Assignment(s.split(",")[0]);
            Assignment assignment2 = new Assignment(s.split(",")[1]);

            if (assignment1.isContainsAny(assignment2) ||
                    assignment2.isContainsAny(assignment1))
            {
                listOfAnyDuplicatedAssignments.add(s);
            }

        }
        System.out.println("Total any contained assignments: " + listOfAnyDuplicatedAssignments.size());

        System.out.println("Ending " + inputLabel);
    }


    }
