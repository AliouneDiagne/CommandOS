package com.commandos.commands;

import com.commandos.core.Command;
import com.commandos.fs.DirComposite;
import com.commandos.fs.FsNode;
import com.commandos.fs.FileLeaf;
import com.commandos.infra.SingletonLogger;

/**
 * Copia file virtuale: copy <src> <dest>
 */
public class CopyCommand implements Command {
    private final String[] tokens;
    private static final SingletonLogger LOG = SingletonLogger.getInstance();

    public CopyCommand(String[] tokens) {
        this.tokens = tokens;
    }

    @Override
    public void execute() {
        if (tokens.length != 3) {
            System.out.println("Usage: copy <src> <dest>");
            return;
        }
        // Demo: copia fittizia su root
        DirComposite root = new DirComposite("/"); // TODO: usare FSContext
        FsNode src = root.find(tokens[1]);
        if (src instanceof FileLeaf file) {
            FileLeaf copy = new FileLeaf(tokens[2]);
            copy.setContent(file.getContent());
            root.add(copy);
            System.out.println("Copied " + tokens[1] + " to " + tokens[2]);
        } else {
            System.out.println("Source file not found: " + tokens[1]);
        }
        LOG.info("copy command executed from " + tokens[1] + " to " + tokens[2]);
    }
}
