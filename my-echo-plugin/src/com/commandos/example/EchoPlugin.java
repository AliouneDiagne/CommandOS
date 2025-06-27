package com.commandos.example;

import com.commandos.core.Command;
import com.commandos.plugin.Plugin;

/**
 * Plugin demo che implementa il comando "echo".
 */
public class EchoPlugin implements Plugin {
    @Override
    public String name() {
        return "echo";
    }

    @Override
    public Command create(String[] tokens) {
        return new EchoPluginCommand(tokens);
    }

    /** Comando plugin reale */
    public static class EchoPluginCommand implements Command {
        private final String[] tokens;
        public EchoPluginCommand(String[] tokens) {
            this.tokens = tokens;
        }
        @Override
        public void execute() {
            if (tokens.length < 2) {
                System.out.println();
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < tokens.length; i++) {
                    sb.append(tokens[i]);
                    if (i < tokens.length - 1) sb.append(" ");
                }
                System.out.println("[PLUGIN-ECHO] " + sb);
            }
        }
    }
}
