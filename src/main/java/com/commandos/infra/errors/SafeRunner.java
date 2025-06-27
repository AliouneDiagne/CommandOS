package com.commandos.infra.errors;

import com.commandos.core.Command;
import com.commandos.infra.SingletonLogger;

/**
 * Avvolge l'esecuzione di un Command isolando tutte le eccezioni.
 * Applica Exception Shielding: mai stack-trace all'utente.
 */
public final class SafeRunner {
    private static final SingletonLogger LOG = SingletonLogger.getInstance();

    private SafeRunner() {}

    public static void run(Command cmd) {
        try {
            cmd.execute();
        } catch (IllegalArgumentException ex) {
            System.err.println("Input non valido: " + ex.getMessage());
            LOG.warn("IllegalArgument: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Internal error. See logs.");
            LOG.error("Unhandled exception in command", ex);
        }
    }
}
