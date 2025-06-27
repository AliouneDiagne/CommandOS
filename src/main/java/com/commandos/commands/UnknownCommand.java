package com.commandos.commands;

import com.commandos.core.Command;
import com.commandos.infra.SingletonLogger;

/**
 * Comando fallback per keyword sconosciute.
 */
public class UnknownCommand implements Command {
    private final String keyword;
    private static final SingletonLogger LOG = SingletonLogger.getInstance();

    public UnknownCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute() {
        System.out.println("Unknown command: " + keyword);
        LOG.warn("UnknownCommand: " + keyword);
    }
}
