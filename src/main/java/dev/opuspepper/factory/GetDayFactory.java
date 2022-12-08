package dev.opuspepper.factory;

import dev.opuspepper.AdventOfCodeDay1.Day1;
import dev.opuspepper.AdventOfCodeDay2.Day2;
import dev.opuspepper.AdventOfCodeDay3.Day3;
import dev.opuspepper.AdventOfCodeDay4.Day4;
import dev.opuspepper.AdventOfCodeDay5.Day5;
import dev.opuspepper.AdventOfCodeDay6.Day6;
import dev.opuspepper.AdventOfCodeDay7.Day7;
import dev.opuspepper.AdventOfCodeDay8.Day8;
import dev.opuspepper.AdventOfCodeDay9.Day9;
import dev.opuspepper.abstracts.Day;

public class GetDayFactory {

    public Day getDay(int dayNumber)
    {
        switch(dayNumber) {
            case 1:
                return new Day1();
            case 2:
                return new Day2();
            case 3:
                return new Day3();
            case 4:
                return new Day4();
            case 5:
                return new Day5();
            case 6:
                return new Day6();
            case 7:
                return new Day7();
            case 8:
                return new Day8();
            case 9:
                return new Day9();
            default:
                return null;
        }
    }
}
