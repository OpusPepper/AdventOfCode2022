package dev.opuspepper.AdventOfCodeDay7.objects;

public class FileContentImpl implements FolderContent {

    protected String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    protected Integer size;
}
