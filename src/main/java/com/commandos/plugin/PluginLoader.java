package com.commandos.plugin;

import com.commandos.core.Command;
import com.commandos.infra.SingletonLogger;

import java.util.ServiceLoader;

/**
 * Loader dinamico di plugin tramite SPI (ServiceLoader).
 */
public final class PluginLoader {
    private static final SingletonLogger LOG = SingletonLogger.getInstance();

    private PluginLoader() {}

    /**
     * Cerca e crea il comando plugin richiesto.
     */
    public static Command load(String[] tokens) {
        if (tokens.length == 0) return null;
        String verb = tokens[0].toLowerCase();
        for (Plugin plugin : ServiceLoader.load(Plugin.class)) {
            if (plugin.name().equalsIgnoreCase(verb)) {
                LOG.info("Plugin found: " + verb);
                return plugin.create(tokens);
            }
        }
        LOG.warn("Plugin not found: " + verb);
        return null;
    }
}
