package com.commandos.commands;

import com.commandos.core.Command;

/**
 * Mostra la cronologia dei comandi (demo: reale solo se gestito da shell).
 */
public class HistoryCommand implements Command {
    @Override
    public void execute() {
        System.out.println("History feature: see implemented in Shell/HistoryIterator");
    }
}
