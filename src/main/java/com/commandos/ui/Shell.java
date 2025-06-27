package com.commandos.ui;

import com.commandos.core.Command;
import com.commandos.core.HistoryIterator;
import com.commandos.core.factory.CommandFactory;
import com.commandos.infra.SingletonLogger;
import com.commandos.infra.errors.SafeRunner;
import com.commandos.strategy.ExecutionStrategy;
import com.commandos.strategy.SyncStrategy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Main CLI shell loop di CommandOS.
 */
public class Shell {
    private static final SingletonLogger LOG = SingletonLogger.getInstance();
    private static final String PROMPT = "CommandOS >>> ";

    private final List<Command> history = new ArrayList<>();
    private ExecutionStrategy strategy = new SyncStrategy();

    /** Per cambiare strategia (sync/async) */
    public void setStrategy(ExecutionStrategy strategy) {
        this.strategy = strategy;
    }

    public void start() {
        System.out.println("Welcome to CommandOS – type 'help' for commands.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        try {
            while (true) {
                System.out.print(PROMPT);
                line = br.readLine();
                if (line == null || line.equalsIgnoreCase("exit")) break;
                if (line.trim().isEmpty()) continue;

                Command cmd = CommandFactory.build(line);
                history.add(cmd);
                SafeRunner.run(() -> strategy.execute(cmd));
            }
        } catch (Exception e) {
            LOG.error("Fatal shell error", e);
        } finally {
            System.out.println("Bye 👋");
        }
    }

    /** Espone la history per test e iterator */
    public List<Command> history() {
        return List.copyOf(history);
    }

    /** Permette di iterare la cronologia */
    public HistoryIterator getHistoryIterator() {
        return new HistoryIterator(history);
    }
}
