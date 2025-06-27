package com.commandos.strategy;

import com.commandos.core.Command;

/**
 * Interfaccia Strategy per esecuzione di un comando (sync/async).
 */
public interface ExecutionStrategy {
    void execute(Command cmd);
}
