package dev.opuspepper.AdventOfCodeDay7.objects;

import java.util.ArrayList;
import java.util.Objects;

public class FolderImpl implements FolderContent{

    protected FolderImpl parent;

    public ArrayList<FolderContent> contents = new ArrayList<>();

    protected String name;

    protected Integer size;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FolderImpl folder = (FolderImpl) o;
        return Objects.equals(parent, folder.parent) && name.equals(folder.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent, name);
    }

    public FolderImpl getParent() {
        return parent;
    }

    public void setParent(FolderImpl parent) {
        this.parent = parent;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
