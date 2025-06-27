package com.commandos.plugin;

import com.commandos.core.Command;

/**
 * Contratto base per ogni plugin CommandOS.
 */
public interface Plugin {
    /**
     * Nome del comando supportato dal plugin (es. "echo").
     */
    String name();

    /**
     * Crea una istanza di Command dal plugin.
     */
    Command create(String[] tokens);
}
