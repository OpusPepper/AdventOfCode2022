package dev.opuspepper.AdventOfCodeDay9;

import dev.opuspepper.AdventOfCodeDay9.objects.coordinate;
import dev.opuspepper.abstracts.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Day9 extends Day {
    public void getDay() {
        day = 9;
    }

    private ArrayList<coordinate> headCoordinates = new ArrayList<>();
    private ArrayList<coordinate> tailCoordinates = new ArrayList<>();
    private coordinate currentHead;
    private coordinate currentTail;

    public void part1(List<String> recordsIn, String inputLabel) {
        System.out.println("Starting " + inputLabel);
        Integer numberOfRows = 0;
        Integer numberOfColumns = 0;

        coordinate currentCoordinate = new coordinate(0, 0);

        coordinate newCoordinate = new coordinate(0, 0);
        headCoordinates.add(newCoordinate);
        currentHead = newCoordinate;
        newCoordinate = new coordinate(0, 0);
        tailCoordinates.add(newCoordinate);
        currentTail = newCoordinate;

        for (String s : recordsIn
        ) {
            System.out.println("Calculating move: " + s);
            System.out.println("CurrentHead: " + currentHead.toString() + ", CurrentTail: " + currentTail.toString());
            String[] words = s.split(" ");
            calculateMove(words);
            //toGrid();
            //mapMyMove();
        }

        System.out.println("Total unique tail moves: " + tailCoordinates.size());
        System.out.println("Total unique head moves: " + headCoordinates.size());
        System.out.println("Last head position: " + currentHead.toString());
        System.out.println("Last tail position: " + currentTail.toString());

        //toGrid();

        System.out.println("Ending " + inputLabel);
    }

    public void part2(List<String> recordsIn, String inputLabel) {
        System.out.println("Starting " + inputLabel);


        System.out.println("Ending " + inputLabel);
    }

    public void calculateMove(String[] inWords) {
        Integer timesToRepeat = Integer.parseInt(inWords[1]);
        //System.out.println("- Direction: " + inWords[0]);
        //System.out.println("- Times: " + inWords[1]);

        for (int i = 0; i < timesToRepeat; i++) {
            coordinate newCoordinate = new coordinate(0, 0);
            switch (inWords[0]) {
                case "U":
                    newCoordinate = new coordinate(currentHead.row + 1, currentHead.column);
                    break;
                case "D":
                    newCoordinate = new coordinate(currentHead.row - 1, currentHead.column);
                    break;
                case "L":
                    newCoordinate = new coordinate(currentHead.row, currentHead.column - 1);
                    break;
                case "R":
                    newCoordinate = new coordinate(currentHead.row, currentHead.column + 1);
                    break;
            }

            // move head
            if (!headCoordinates.contains(newCoordinate)) {
                headCoordinates.add(newCoordinate);
                currentHead = newCoordinate;
            } else {
                Integer indexOfObject = headCoordinates.indexOf(newCoordinate);
                currentHead = headCoordinates.get(indexOfObject);
            }

            moveTail();
            System.out.println("-- CurrentHead: " + currentHead.toString() + ", CurrentTail: " + currentTail.toString());
        }
    }

    private void moveTail() {
        if (headIsNearTail()) {
            //System.out.println("--Head is near tail: -- CurrentHead: " + currentHead.toString() + ", CurrentTail: " + currentTail.toString());
            return;
        }

        Integer newTailRow = 0;
        Integer newTailColumn = 0;
        coordinate newTailCoordinate = new coordinate(0, 0);
        if ((currentHead.row != currentTail.row) &&
                (currentHead.column != currentTail.column)) {

            // Move diagonally
            if ((currentHead.row > currentTail.row) &&
                    (currentHead.column > currentTail.column)) {
                newTailRow = currentTail.row + 1;
                newTailColumn = currentTail.column + 1;
            } else if ((currentHead.row > currentTail.row) &&
                    (currentHead.column < currentTail.column)) {
                newTailRow = currentTail.row + 1;
                newTailColumn = currentTail.column - 1;
            } else if ((currentHead.row < currentTail.row) &&
                    (currentHead.column > currentTail.column)) {
                newTailRow = currentTail.row - 1;
                newTailColumn = currentTail.column + 1;
            } else if ((currentHead.row < currentTail.row) &&
                    (currentHead.column < currentTail.column)) {
                newTailRow = currentTail.row - 1;
                newTailColumn = currentTail.column - 1;
            }

            newTailCoordinate = new coordinate(newTailRow, newTailColumn);


        } else {
            if (currentHead.row == currentTail.row) {
                newTailRow = currentTail.row;
                // move column
                if (currentHead.column < currentTail.column) {
                    newTailColumn = currentTail.column - 1;
                } else if (currentHead.column > currentTail.column) {
                    newTailColumn = currentTail.column + 1;
                }
            } else if (currentHead.column == currentTail.column) {
                newTailColumn = currentTail.column;
                // move row
                if (currentHead.row < currentTail.row) {
                    newTailRow = currentTail.row - 1;
                } else if (currentHead.row > currentTail.row) {
                    newTailRow = currentTail.row + 1;
                }
            }
            newTailCoordinate = new coordinate(newTailRow, newTailColumn);
        }
        if (!tailCoordinates.contains(newTailCoordinate)) {
            tailCoordinates.add(newTailCoordinate);
            currentTail = newTailCoordinate;
        } else {
            Integer indexOfObject = tailCoordinates.indexOf(newTailCoordinate);
            currentTail = tailCoordinates.get(indexOfObject);
        }
    }

    private Boolean headIsNearTail() {
        if ((currentTail.row == currentHead.row) &&
                (currentTail.column == currentHead.column)) {
            return true;
        }
        Integer distanceHeadRow = currentTail.row - currentHead.row;
        Integer distanceHeadColumn = currentTail.column - currentHead.column;
        if ((-1 <= distanceHeadRow && distanceHeadRow <= 1) &&
        (-1 <= distanceHeadColumn && distanceHeadColumn <= 1))
        {
            return true;
        }

        return false;
    }

    private void toGrid() {
        Integer maxRow = 0;
        Integer maxColumn = 0;

        for (coordinate c : tailCoordinates
        ) {
            if (maxRow < c.row) {
                maxRow = c.row;
            }
            if (maxColumn < c.column) {
                maxColumn = c.column;
            }
        }

        for (int row = maxRow; row >= 0; row--) {
            for (int column = 0; column <= (maxColumn + 1); column++) {
                coordinate testCoordinate = new coordinate(row, column);
                if (tailCoordinates.contains(testCoordinate)) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    private void mapMyMove()
    {
        Integer maxRow = 5;
        Integer maxColumn = 6;

        for (int row = maxRow; row >= 0; row--) {
            for (int column = 0; column <= (maxColumn + 1); column++) {
                if (row == currentHead.row && column == currentHead.column) {
                    System.out.print("H");
                }
                else if (row == currentTail.row && column == currentTail.column)
                {
                    System.out.print("T");
                }
                    else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    }
