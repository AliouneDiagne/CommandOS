package com.commandos.fs;

import java.util.List;

/**
 * Nodo astratto del FileSystem virtuale.
 * Può essere File (foglia) o Dir (composito).
 * Pattern: Composite.
 */
public abstract class FsNode {
    protected final String name;

    protected FsNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /** Directory = true, File = false */
    public abstract boolean isDirectory();

    /** Solo DirComposite ha figli */
    public List<FsNode> getChildren() {
        throw new UnsupportedOperationException("Not a directory");
    }
}
