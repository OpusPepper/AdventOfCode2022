package dev.opuspepper.AdventOfCodeDay5;

import dev.opuspepper.AdventOfCodeDay4.objects.Assignment;
import dev.opuspepper.AdventOfCodeDay5.objects.CrateStack;
import dev.opuspepper.AdventOfCodeDay5.objects.Instruction;
import dev.opuspepper.abstracts.Day;

import java.util.ArrayList;
import java.util.List;

public class Day5 extends Day {
    public void getDay()
    {
        day = 5;
    }
    public void part1(List<String> recordsIn, String inputLabel)
    {
        System.out.println("Starting " + inputLabel);
        ArrayList<String> listOfDuplicatedAssignments = new ArrayList<>();

        Integer crateStackLineLength = recordsIn.get(0).length();
        ArrayList<CrateStack> crates = new ArrayList<>();
        ArrayList<Instruction> instructions = new ArrayList<>();

        for (String s : recordsIn
             ) {
            String readLineForCrate = s;

            if (s.length() > 0 && s.toCharArray()[0] != 'm') {  // we have a crate row
                System.out.println("Craterow: " + s);

                Integer crateIndex = 0;
                // Build Stacks
                while (readLineForCrate.length() > 0) {
                    CrateStack workingCrateStack;

                    if (crates.isEmpty() || crateIndex > (crates.size() - 1))
                    {
                        CrateStack newCreateStack = new CrateStack();

                        crates.add(newCreateStack);
                    }
                    workingCrateStack = crates.get(crateIndex);

                    String tempStringFourCharacters = readOffFourCharacters(readLineForCrate);
                    System.out.println("Evaluating String: "+ tempStringFourCharacters);

                    if (tempStringFourCharacters.contains("[")) {
                        workingCrateStack.itemsInCrate.add(tempStringFourCharacters.substring(1, 2).toCharArray()[0]);
                    }
                    else if (tempStringFourCharacters.toCharArray()[1] != ' ')
                    {
                        workingCrateStack.setCrateNumber(Integer.parseInt(tempStringFourCharacters.trim()));
                    }
                    if (readLineForCrate.length() > 3){
                        readLineForCrate = readLineForCrate.substring(4, readLineForCrate.length());
                    }
                    else {
                        readLineForCrate = "";
                    }
                    crateIndex++;
                }
            }
            else if (s.length() != 0)
            {
                Instruction newInstruction = new Instruction(s);
                instructions.add(newInstruction);
            }
        }

        for (CrateStack cs : crates
             ) {
            System.out.println(cs.toString());
        }

        for (Instruction i : instructions
             ) {
            for (int x = 0; x < i.getNumberOfCratesToMove(); x++ )
            {
                Integer tempIndex = i.getToCrateStack() - 1;
                CrateStack workingFromCrate = crates.get(i.getFromCrateStack() - 1);
                CrateStack workingToCrate = crates.get(i.getToCrateStack() - 1);
                Character poppedItem = workingFromCrate.itemsInCrate.get(0);
                workingFromCrate.itemsInCrate.remove(0);
                //workingFromCrate.itemsInCrate.remove(workingFromCrate.itemsInCrate.size() - 1);
                workingToCrate.itemsInCrate.add(0, poppedItem);
            }
            System.out.println("After instruction applied, from crate: " + crates.get(i.getFromCrateStack() -1).toString());
            System.out.println("After instruction applied, to crate: " + crates.get(i.getToCrateStack() - 1).toString());
        }

        StringBuilder sb = new StringBuilder();
        for (CrateStack cs : crates
             ) {

            sb.append(cs.itemsInCrate.get(0));
        }
        System.out.println("String from tops of crates: " + sb.toString());

        System.out.println("Ending " + inputLabel);
    }

    public void part2(List<String> recordsIn, String inputLabel) {
        System.out.println("Starting " + inputLabel);
        ArrayList<String> listOfDuplicatedAssignments = new ArrayList<>();

        Integer crateStackLineLength = recordsIn.get(0).length();
        ArrayList<CrateStack> crates = new ArrayList<>();
        ArrayList<Instruction> instructions = new ArrayList<>();

        for (String s : recordsIn
        ) {
            String readLineForCrate = s;

            if (s.length() > 0 && s.toCharArray()[0] != 'm') {  // we have a crate row
                System.out.println("Craterow: " + s);

                Integer crateIndex = 0;
                // Build Stacks
                while (readLineForCrate.length() > 0) {
                    CrateStack workingCrateStack;

                    if (crates.isEmpty() || crateIndex > (crates.size() - 1))
                    {
                        CrateStack newCreateStack = new CrateStack();

                        crates.add(newCreateStack);
                    }
                    workingCrateStack = crates.get(crateIndex);

                    String tempStringFourCharacters = readOffFourCharacters(readLineForCrate);
                    System.out.println("Evaluating String: "+ tempStringFourCharacters);

                    if (tempStringFourCharacters.contains("[")) {
                        workingCrateStack.itemsInCrate.add(tempStringFourCharacters.substring(1, 2).toCharArray()[0]);
                    }
                    else if (tempStringFourCharacters.toCharArray()[1] != ' ')
                    {
                        workingCrateStack.setCrateNumber(Integer.parseInt(tempStringFourCharacters.trim()));
                    }
                    if (readLineForCrate.length() > 3){
                        readLineForCrate = readLineForCrate.substring(4, readLineForCrate.length());
                    }
                    else {
                        readLineForCrate = "";
                    }
                    crateIndex++;
                }
            }
            else if (s.length() != 0)
            {
                Instruction newInstruction = new Instruction(s);
                instructions.add(newInstruction);
            }
        }

        for (CrateStack cs : crates
        ) {
            System.out.println(cs.toString());
        }

        for (Instruction i : instructions
        ) {
            StringBuilder stackStringToAdd = new StringBuilder();
            CrateStack workingFromCrate = crates.get(i.getFromCrateStack() - 1);
            CrateStack workingToCrate = crates.get(i.getToCrateStack() - 1);
            for (int x = 0; x < i.getNumberOfCratesToMove(); x++ )
            {
                Integer tempIndex = i.getToCrateStack() - 1;
                Character poppedItem = workingFromCrate.itemsInCrate.get(0);
                workingFromCrate.itemsInCrate.remove(0);
                stackStringToAdd.append(poppedItem.toString());
                //workingFromCrate.itemsInCrate.remove(workingFromCrate.itemsInCrate.size() - 1);
                //workingToCrate.itemsInCrate.add(0, poppedItem);
            }
            for (Character c : stackStringToAdd.reverse().toString().toCharArray()
                 ) {
                workingToCrate.itemsInCrate.add(0, c);
            }
            System.out.println("After instruction applied, from crate: " + crates.get(i.getFromCrateStack() -1).toString());
            System.out.println("After instruction applied, to crate: " + crates.get(i.getToCrateStack() - 1).toString());
        }

        StringBuilder sb = new StringBuilder();
        for (CrateStack cs : crates
        ) {

            sb.append(cs.itemsInCrate.get(0));
        }
        System.out.println("String from tops of crates: " + sb.toString());

        System.out.println("Ending " + inputLabel);
    }

    private String readOffFourCharacters(String inputString)
    {
        Integer endIndex = 3;  // only 4 characters max per time
        if (inputString.length() < (endIndex + 1))
        {
            endIndex = inputString.length();
        }
        String returnString = inputString.substring(0, endIndex);
        return returnString;
    }


    }
