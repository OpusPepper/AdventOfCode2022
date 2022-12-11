package dev.opuspepper.AdventOfCodeDay11;

import dev.opuspepper.AdventOfCodeDay10.objects.pixel;
import dev.opuspepper.AdventOfCodeDay11.objects.monkey;
import dev.opuspepper.abstracts.Day;

import java.util.ArrayList;
import java.util.List;

public class Day11 extends Day {
    public void getDay() {
        day = 11;
    }

    private ArrayList<monkey> monkeys = new ArrayList<>();
    public void part1(List<String> recordsIn, String inputLabel) {
        System.out.println("Starting " + inputLabel);

        boolean newMonkeyFound = false;
        Integer monkeyId = 0;
        monkey currentMonkey = new monkey(0);
        for (String s : recordsIn
        ) {
            String[] words = s.split(" ");

            if (words[0].equalsIgnoreCase("monkey"))
            {
                monkeyId = Integer.parseInt(words[1].split("\\d+")[0]);
                newMonkeyFound = true;
                currentMonkey = new monkey(monkeyId);
                monkeys.add(currentMonkey);
            }
            else if (words[0].equalsIgnoreCase("starting"))
            {
                for (String num:s.split("\\d+")
                     ) {
                    currentMonkey.items.add(Integer.parseInt(num));
                }
            }
            else if ()
            {

            }

        }

        System.out.println("Ending " + inputLabel);
    }

    public void part2(List<String> recordsIn, String inputLabel) {
        System.out.println("Starting " + inputLabel);

        System.out.println("Ending " + inputLabel);
    }

}
