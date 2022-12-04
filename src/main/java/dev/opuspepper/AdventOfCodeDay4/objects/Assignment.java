package dev.opuspepper.AdventOfCodeDay4.objects;

import jdk.jshell.spi.ExecutionControl;

public class Assignment {
    public Assignment(String oneAssignementString) {
        this.startNumber = Integer.valueOf(oneAssignementString.split("-")[0]);
        this.endNumber = Integer.valueOf(oneAssignementString.split("-")[1]);
    }

    protected Integer startNumber;
    protected Integer endNumber;

    public Boolean isFullyContains(Assignment assignmentCompare)
    {
        return (this.startNumber <= assignmentCompare.startNumber &&
                this.endNumber >= assignmentCompare.endNumber);
    }

    public Boolean isContainsAny(Assignment assignmentCompare)
    {
        return ((this.startNumber <= assignmentCompare.startNumber &&
                this.endNumber >= assignmentCompare.startNumber) ||
                (this.startNumber <= assignmentCompare.endNumber &&
                        this.endNumber >= assignmentCompare.endNumber));
    }
}
