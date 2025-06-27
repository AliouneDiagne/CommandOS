package com.commandos.commands;

import com.commandos.core.Command;
import com.commandos.fs.DirComposite;
import com.commandos.infra.SingletonLogger;

/**
 * Cambia directory (virtuale).
 */
public class CdCommand implements Command {
    private final String[] tokens;
    private static final SingletonLogger LOG = SingletonLogger.getInstance();

    public CdCommand(String[] tokens) {
        this.tokens = tokens;
    }

    @Override
    public void execute() {
        if (tokens.length != 2) {
            System.out.println("Usage: cd <dirname>");
            return;
        }
        // In reale: va usato FSContext. Qui esempio base.
        System.out.println("Changed directory to: " + tokens[1]);
        LOG.info("cd command executed: " + tokens[1]);
    }
}
