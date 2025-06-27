package com.commandos.strategy;

import com.commandos.core.Command;

/**
 * Strategy: esecuzione sincrona (default).
 */
public class SyncStrategy implements ExecutionStrategy {
    @Override
    public void execute(Command cmd) {
        cmd.execute();
    }
}
