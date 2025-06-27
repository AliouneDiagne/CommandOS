package com.commandos.strategy;

import com.commandos.core.Command;
import java.util.concurrent.*;

/**
 * Strategy: esecuzione asincrona su un thread separato.
 */
public class AsyncStrategy implements ExecutionStrategy {
    private final ExecutorService executor = Executors.newCachedThreadPool();

    @Override
    public void execute(Command cmd) {
        executor.submit(cmd::execute);
    }

    public void shutdown() {
        executor.shutdownNow();
    }
}
