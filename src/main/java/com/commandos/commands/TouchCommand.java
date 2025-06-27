package com.commandos.commands;

import com.commandos.core.Command;
import com.commandos.fs.DirComposite;
import com.commandos.fs.FileLeaf;
import com.commandos.infra.SingletonLogger;

/**
 * Crea un file vuoto: touch <filename>
 */
public class TouchCommand implements Command {
    private final String[] tokens;
    private static final SingletonLogger LOG = SingletonLogger.getInstance();

    public TouchCommand(String[] tokens) {
        this.tokens = tokens;
    }

    @Override
    public void execute() {
        if (tokens.length != 2) {
            System.out.println("Usage: touch <filename>");
            return;
        }
        DirComposite root = new DirComposite("/"); // TODO: usa FSContext
        root.add(new FileLeaf(tokens[1]));
        System.out.println("File created: " + tokens[1]);
        LOG.info("touch command executed: " + tokens[1]);
    }
}
