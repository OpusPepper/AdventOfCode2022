package dev.opuspepper.AdventOfCodeDay9.objects;

import java.util.Objects;

public class coordinate {
    public Integer row = 0;
    public Integer column = 0;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        coordinate that = (coordinate) o;
        return row.equals(that.row) && column.equals(that.column);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    public coordinate(Integer row, Integer column) {
        this.row = row;
        this.column = column;

        numberOfTimesUsed = 1;
    }



    @Override
    public String toString() {
        return "coordinate{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }

    public Integer numberOfTimesUsed = 0;
}
