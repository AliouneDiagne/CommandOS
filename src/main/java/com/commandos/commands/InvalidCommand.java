package com.commandos.commands;

import com.commandos.core.Command;
import com.commandos.infra.SingletonLogger;

/**
 * Comando per input non valido.
 */
public class InvalidCommand implements Command {
    private final String reason;
    private static final SingletonLogger LOG = SingletonLogger.getInstance();

    public InvalidCommand(String reason) {
        this.reason = reason;
    }

    @Override
    public void execute() {
        System.out.println("Invalid command. " + reason);
        LOG.warn("InvalidCommand: " + reason);
    }
}
