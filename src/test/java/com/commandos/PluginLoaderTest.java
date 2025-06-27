package com.commandos;

import com.commandos.core.Command;
import com.commandos.plugin.PluginLoader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PluginLoaderTest {
    @Test
    void returnsNullIfNoPluginFound() {
        String[] tokens = {"notaplugincmd"};
        Command cmd = PluginLoader.load(tokens);
        assertNull(cmd); // Nessun plugin con questo nome
    }

    // Nota: Per testare veri plugin serve un JAR plugin nel classpath/test-resources
}
