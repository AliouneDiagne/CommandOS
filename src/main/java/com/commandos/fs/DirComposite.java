package com.commandos.fs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Directory virtuale (composito): può contenere altri FsNode (dir o file).
 */
public class DirComposite extends FsNode {
    private final List<FsNode> children = new ArrayList<>();

    public DirComposite(String name) {
        super(name);
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public List<FsNode> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void add(FsNode node) {
        children.add(node);
    }

    public void remove(FsNode node) {
        children.remove(node);
    }

    /** Cerca figlio per nome */
    public FsNode find(String name) {
        return children.stream()
                .filter(n -> n.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
