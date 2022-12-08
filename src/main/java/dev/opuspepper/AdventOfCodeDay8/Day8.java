package dev.opuspepper.AdventOfCodeDay8;

import dev.opuspepper.AdventOfCodeDay5.objects.CrateStack;
import dev.opuspepper.AdventOfCodeDay5.objects.Instruction;
import dev.opuspepper.abstracts.Day;

import java.util.ArrayList;
import java.util.List;

public class Day8 extends Day {
    public void getDay()
    {
        day = 8;
    }
    private Integer[][] treeMap;
    private Integer visibleTrees = 0;
    public void part1(List<String> recordsIn, String inputLabel) {
        System.out.println("Starting " + inputLabel);
        Integer numberOfColumns = recordsIn.get(0).length();
        Integer numberOfRows = recordsIn.size();
        treeMap = new Integer[numberOfRows][numberOfColumns];

        for (int row = 0; row < numberOfRows; row++)
        {
            for (int column = 0; column < numberOfColumns; column++)
            {
                treeMap[row][column] = Integer.valueOf(recordsIn.get(row).toCharArray()[column]);
            }
        }

        //visibleTrees = (2 * numberOfColumns) + ((numberOfRows - 2) * 2); // default visible trees on the edges

        for (int row = 0; row < numberOfRows; row++)
        {
            for (int column = 0; column < numberOfColumns; column++)
            {
                Boolean isVisible = isVisible(row, column);
                if (isVisible)
                {
                    visibleTrees++;
                }
            }
        }

        System.out.println("Total visible trees: " + visibleTrees);


        System.out.println("Ending " + inputLabel);
    }

    public void part2(List<String> recordsIn, String inputLabel) {
        System.out.println("Starting " + inputLabel);
        Integer numberOfColumns = recordsIn.get(0).length();
        Integer numberOfRows = recordsIn.size();
        treeMap = new Integer[numberOfRows][numberOfColumns];

        for (int row = 0; row < numberOfRows; row++)
        {
            for (int column = 0; column < numberOfColumns; column++)
            {
                //System.out.println("Loading char: " + Integer.parseInt(String.valueOf(recordsIn.get(row).toCharArray()[column])));
                treeMap[row][column] = Integer.parseInt(String.valueOf(recordsIn.get(row).toCharArray()[column]));
            }
        }

        Integer maxScenicScore = 0;
        for (int row = 0; row < numberOfRows; row++)
        {
            for (int column = 0; column < numberOfColumns; column++)
            {
                Integer scenicScoreCurrent = calculateScenicScore(row, column);
                if (maxScenicScore < scenicScoreCurrent)
                {
                    maxScenicScore = scenicScoreCurrent;
                }
            }
        }

        System.out.println("Max scenic score: " + maxScenicScore);


        System.out.println("Ending " + inputLabel);
    }

    public Integer calculateScenicScore(Integer row, Integer column)
    {
        /* System.out.println("Treemap[" + row + "][" + column + "]: " + treeMap[row][column] +
                " | " +
                calculateTop(row, column) + " * " +
                calculateLeft(row, column) + " * " +
                calculateBottom(row, column) + " * " +
                calculateRight(row, column)); */
        return (calculateRight(row, column) *
                calculateBottom(row, column) *
                calculateLeft(row, column) *
                calculateTop (row, column));
    }

    public Boolean isVisible(Integer row, Integer column)
    {
        return isVisibleFromBottom(row, column) ||
                isVisibleFromRight(row, column) ||
                isVisibleFromTop(row, column) ||
                isVisibleFromLeft(row, column);

    }

    public Boolean isVisibleFromTop(Integer row, Integer column)
    {
        if (row == 0)
        {
            return true;
        }
        Integer treeHeight = treeMap[row][column];
        for (int rowAbove = row - 1; rowAbove > -1; rowAbove--) {
            if (treeHeight <= treeMap[rowAbove][column])
            {
                return false;  // we found a tree the same height or bigger in the map
            }
        }
        return true;
    }
    public Boolean isVisibleFromBottom(Integer row, Integer column)
    {
        if (row == (treeMap.length - 1))
        {
            return true;
        }
        Integer treeHeight = treeMap[row][column];
        for (int rowBelow = row + 1; rowBelow < treeMap.length; rowBelow++) {
            if (treeHeight <= treeMap[rowBelow][column])
            {
                return false;  // we found a tree the same height or bigger in the map
            }
        }
        return true;
    }

    public Boolean isVisibleFromRight(Integer row, Integer column)
    {
        if (column == (treeMap[0].length - 1))
        {
            return true;
        }
        Integer treeHeight = treeMap[row][column];
        for (int columnToRight = column + 1; columnToRight < treeMap[0].length; columnToRight++) {
            if (treeHeight <= treeMap[row][columnToRight])
            {
                return false;  // we found a tree the same height or bigger in the map
            }
        }
        return true;
    }

    public Boolean isVisibleFromLeft(Integer row, Integer column)
    {
        if (column == 0)
        {
            return true;
        }
        Integer treeHeight = treeMap[row][column];
        for (int columnToLeft = column - 1; columnToLeft > -1; columnToLeft--) {
            if (treeHeight <= treeMap[row][columnToLeft])
            {
                return false;  // we found a tree the same height or bigger in the map
            }
        }
        return true;
    }

    public Integer calculateTop(Integer row, Integer column)
    {
        if (row == 0)
        {
            return 0;
        }
        Integer counter = 0;
        Integer treeHeight = treeMap[row][column];
        for (int rowAbove = row - 1; rowAbove > -1; rowAbove--) {
            counter++;
            if (treeHeight <= treeMap[rowAbove][column]) {
                break;
            }

        }
        return counter;
    }
    public Integer calculateBottom(Integer row, Integer column)
    {
        if (row == (treeMap.length - 1))
        {
            return 0;
        }
        Integer counter = 0;
        Integer treeHeight = treeMap[row][column];
        for (int rowBelow = row + 1; rowBelow < treeMap.length; rowBelow++) {
            counter++;
            if (treeHeight <= treeMap[rowBelow][column]) {
                break;
            }

        }
        return counter;
    }
    public Integer calculateRight(Integer row, Integer column)
    {
        if (column == (treeMap[0].length - 1))
        {
            return 0;
        }
        Integer counter = 0;
        Integer treeHeight = treeMap[row][column];
        for (int columnRight = column + 1; columnRight < treeMap[0].length; columnRight++) {
            counter++;
            if (treeHeight <= treeMap[row][columnRight]) {
                break;
            }

        }
        return counter;
    }
    public Integer calculateLeft(Integer row, Integer column)
    {
        if (column == 0)
        {
            return 0;
        }
        Integer counter = 0;
        Integer treeHeight = treeMap[row][column];
        for (int columnLeft = column - 1; columnLeft > -1; columnLeft--) {
            counter++;
            if (treeHeight <= treeMap[row][columnLeft]) {
                break;
            }

        }
        return counter;
    }

    }
