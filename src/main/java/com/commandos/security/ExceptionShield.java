package com.commandos.security;

import com.commandos.infra.SingletonLogger;

/**
 * Utilità per proteggere blocchi sensibili da eccezioni non gestite.
 */
public class ExceptionShield {
    private static final SingletonLogger LOG = SingletonLogger.getInstance();

    public static void run(Runnable action) {
        try {
            action.run();
        } catch (Exception e) {
            LOG.error("Shielded Exception", e);
        }
    }
}
