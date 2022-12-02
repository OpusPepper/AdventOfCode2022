package dev.opuspepper.helper;

public class FileNamer {
    public FileNamer(int day, int part, String postFix) {
        this.day = day;
        this.part = part;
        this.postFix = postFix;
    }

    private int day = 0;
    private int part = 0;
    private String postFix = "";
    private String label = "";

    public String getFileName () {
        label = "Day" + day + "Part" + part + postFix;
        return label + ".txt";
    }

    public String getLabel() {
        return label;
    }
}
