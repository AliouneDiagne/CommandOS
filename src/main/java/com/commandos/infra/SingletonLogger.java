package com.commandos.infra;

import java.io.IOException;
import java.nio.file.*;
import java.util.logging.*;

/**
 * SingletonLogger centralizza logging su file + console.
 * Rotazione automatica e livelli configurabili.
 */
public final class SingletonLogger {
    private static final SingletonLogger INSTANCE = new SingletonLogger();
    private final Logger logger;

    private SingletonLogger() {
        logger = Logger.getLogger("CommandOS");
        try {
            // Usa la config YAML (data/commandos.log) oppure default HOME/.commandos
            Path logPath = Paths.get("data", "commandos.log");
            Files.createDirectories(logPath.getParent());
            Handler fileHandler = new FileHandler(logPath.toString(), 1_000_000, 3, true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);

            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(consoleHandler);

            logger.setUseParentHandlers(false);
            logger.setLevel(Level.INFO);
        } catch (IOException e) {
            System.err.println("Logger init failed: " + e.getMessage());
        }
    }

    public static SingletonLogger getInstance() {
        return INSTANCE;
    }

    public void info(String msg)  { logger.info(msg); }
    public void warn(String msg)  { logger.warning(msg); }
    public void error(String msg, Throwable ex) {
        logger.log(Level.SEVERE, msg, ex);
    }
}
