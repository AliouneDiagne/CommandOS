package com.commandos.core;

/**
 * Interfaccia base per ogni comando di CommandOS.
 * Pattern: Command.
 */
public interface Command {
    /**
     * Esegue la logica del comando.
     * Tutte le eccezioni sono schermate da SafeRunner.
     */
    void execute();
}
