package dev.opuspepper.AdventOfCodeDay10;

import dev.opuspepper.AdventOfCodeDay10.objects.pixel;
import dev.opuspepper.AdventOfCodeDay9.objects.coordinate;
import dev.opuspepper.abstracts.Day;

import java.util.ArrayList;
import java.util.List;

public class Day10 extends Day {
    public void getDay() {
        day = 10;
    }
    private ArrayList<pixel> onPixels = new ArrayList<>();


    public void part1(List<String> recordsIn, String inputLabel) {
        System.out.println("Starting " + inputLabel);

        Integer x = 1;
        Integer cycle = 0;
        Integer totalCycleSignalStrengths = 0;

        for (int i = 0; i < recordsIn.size(); i++)
        {
            if (cycle != 0)
            {
                totalCycleSignalStrengths += CalculateSignalStrength(x, cycle);
            }

            if (recordsIn.get(i) == "noop")
            {
                cycle++;
                //continue;
            }
            else
            {
                cycle++;
            }


            if (i >= 1 && recordsIn.get(i - 1).contains("addx"))
            {
                String[] words = recordsIn.get(i - 1).split(" ");
                //System.out.println("Cycle # " + cycle + " x is: " + x + " // add " + words[1]);
                totalCycleSignalStrengths += CalculateSignalStrength(x, cycle);
                x = x + (Integer.parseInt(words[1]));
                cycle++;
            }
        }

        System.out.println("Total signal strength is: " + totalCycleSignalStrengths);

        System.out.println("Ending " + inputLabel);
    }

    private Integer CalculateSignalStrength(Integer x, Integer cycle) {
        Integer signalStrength = 0;
        switch(cycle)
        {
            case 20:
            case 60:
            case 100:
            case 140:
            case 180:
            case 220:
                signalStrength = cycle * x;
                System.out.println("Cycle # " + cycle + " x is: " + x + ", Signal strength is (" + cycle + " * " + " " + x +"): " + signalStrength);
                break;
        }
        return signalStrength;
    }

    public void part2(List<String> recordsIn, String inputLabel) {
        System.out.println("Starting " + inputLabel);

        Integer x = 1;
        Integer cycle = 1;
        Integer totalCycleSignalStrengths = 0;
        Integer currentPixel = 0;
        Integer comparePixel = 0;

        for (int i = 0; i < recordsIn.size(); i++)
        {
            totalCycleSignalStrengths += CalculateSignalStrength(x, cycle);

            comparePixel = currentPixel % 40;
            if (comparePixel == x || comparePixel == (x - 1) || comparePixel == (x + 1))
            {
                onPixels.add(new pixel(currentPixel));
            }
            System.out.println("On CPU Cycle # " + cycle + " x is: " + x + ", pixel is " + comparePixel);


            if (i >= 1 && recordsIn.get(i - 1).contains("addx"))
            {
                String[] words = recordsIn.get(i - 1).split(" ");
                //System.out.println("Cycle # " + cycle + " x is: " + x + " // add " + words[1]);
                totalCycleSignalStrengths += CalculateSignalStrength(x, cycle);
                x = x + (Integer.parseInt(words[1]));
                cycle++; currentPixel++;

                comparePixel = currentPixel % 40;
                if (comparePixel == x || comparePixel == (x - 1) || comparePixel == (x + 1))
                {
                    onPixels.add(new pixel(currentPixel));
                }
                System.out.println("On CPU Cycle # " + cycle + " x is: " + x + ", pixel is " + comparePixel);

            }
            cycle++; currentPixel++;
        }

        System.out.println("Total signal strength is: " + totalCycleSignalStrengths);
        System.out.println();
        drawCrt();
        System.out.println();
        System.out.println("Ending " + inputLabel);
    }

    public void drawCrt()
    {
        for (int row = 0; row < 6; row++)
        {
            for (int column = 0; column < 40; column++)
            {
                pixel testPixel = new pixel((row * 40) + (column));
                if (onPixels.contains(testPixel))
                {
                    System.out.print("#");
                }
                else
                {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    }
