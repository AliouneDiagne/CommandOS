package com.commandos.commands;

import com.commandos.core.Command;
import com.commandos.fs.DirComposite;
import com.commandos.fs.FsNode;
import com.commandos.fs.FileLeaf;
import com.commandos.infra.SingletonLogger;

/**
 * Sposta file virtuale: move <src> <dest>
 */
public class MoveCommand implements Command {
    private final String[] tokens;
    private static final SingletonLogger LOG = SingletonLogger.getInstance();

    public MoveCommand(String[] tokens) {
        this.tokens = tokens;
    }

    @Override
    public void execute() {
        if (tokens.length != 3) {
            System.out.println("Usage: move <src> <dest>");
            return;
        }
        DirComposite root = new DirComposite("/"); // TODO: usa FSContext
        FsNode src = root.find(tokens[1]);
        if (src instanceof FileLeaf file) {
            FileLeaf moved = new FileLeaf(tokens[2]);
            moved.setContent(file.getContent());
            root.add(moved);
            root.remove(file);
            System.out.println("Moved " + tokens[1] + " to " + tokens[2]);
        } else {
            System.out.println("Source file not found: " + tokens[1]);
        }
        LOG.info("move command executed from " + tokens[1] + " to " + tokens[2]);
    }
}
