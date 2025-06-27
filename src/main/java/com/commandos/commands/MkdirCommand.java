package com.commandos.commands;

import com.commandos.core.Command;
import com.commandos.fs.DirComposite;
import com.commandos.infra.SingletonLogger;

/**
 * Crea una directory virtuale: mkdir <dirname>
 */
public class MkdirCommand implements Command {
    private final String[] tokens;
    private static final SingletonLogger LOG = SingletonLogger.getInstance();

    public MkdirCommand(String[] tokens) {
        this.tokens = tokens;
    }

    @Override
    public void execute() {
        if (tokens.length != 2) {
            System.out.println("Usage: mkdir <dirname>");
            return;
        }
        DirComposite root = new DirComposite("/"); // TODO: integra con FSContext
        root.add(new DirComposite(tokens[1]));
        System.out.println("Directory created: " + tokens[1]);
        LOG.info("mkdir command executed: " + tokens[1]);
    }
}
