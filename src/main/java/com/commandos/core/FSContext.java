package com.commandos.core;

import com.commandos.fs.DirComposite;

/**
 * FSContext: singleton opzionale per lo stato del file system (es. rootDir, cwd).
 */
public final class FSContext {
    private static FSContext instance;
    private DirComposite root;
    private DirComposite currentDir;

    private FSContext(DirComposite root) {
        this.root = root;
        this.currentDir = root;
    }

    public static FSContext getInstance(DirComposite root) {
        if (instance == null) instance = new FSContext(root);
        return instance;
    }

    public DirComposite getRoot() {
        return root;
    }

    public DirComposite getCurrentDir() {
        return currentDir;
    }

    public void setCurrentDir(DirComposite dir) {
        this.currentDir = dir;
    }
}
