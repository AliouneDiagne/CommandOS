package com.commandos.fs;

/**
 * File virtuale (foglia del composite).
 */
public class FileLeaf extends FsNode {
    private String content = "";

    public FileLeaf(String name) {
        super(name);
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
