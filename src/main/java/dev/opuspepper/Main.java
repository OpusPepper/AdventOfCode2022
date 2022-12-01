package dev.opuspepper;

import dev.opuspepper.AdventOfCodeDay1.Day1;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String basePath = "C:\\Users\\CPJSa\\GitHub\\OpusPepper\\AdventOfCode2022\\src\\main\\resources\\";

        System.out.println("Starting application");
        System.out.println("Starting day 1");
        File inputFile = new File(basePath, "Day1Part1Example.txt");

        Day1 day1 = new Day1();

        switch("day1part2")
        {
            case "day1part1example":
                day1.part1(inputFile, "Day1Part1Example");
                break;
            case "day1part1":
                inputFile = new File(basePath, "Day1Part1Input.txt");
                day1.part1(inputFile, "Day1Part1Input");
                break;
            case "day1part2example":
                    inputFile = new File(basePath, "Day1Part1Example.txt");
                    day1.part2(inputFile, "Day1Part1Example");
                    break;
            case "day1part2":
                inputFile = new File(basePath, "Day1Part1Input.txt");
                day1.part2(inputFile, "Day1Part2Input");
                System.out.println("Ending application");
                break;
        }
    }
}