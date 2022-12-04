package dev.opuspepper.helper;

public class FileNamer {

    public static final String TXTCONST = ".txt";
    public static final String DAYCONST = "Day";
    public static final String PARTCONST = "Part";

    public FileNamer(int day, int part, String postFix) {
        this.day = day;
        this.part = part;
        this.postFix = postFix;
    }

    private final int day;
    private final int part;
    private final String postFix;
    private String label = "";

    public String getFileName () {
        return getLabel() + TXTCONST;
    }

    public String getLabel() {
        return DAYCONST + day + PARTCONST + part + postFix;
    }
}
