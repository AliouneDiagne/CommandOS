package com.commandos.plugins;

import com.commandos.core.Command;

public class PluginEchoCommand implements Command {
    private final String[] tokens;

    public PluginEchoCommand(String[] tokens) {
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
            System.out.println("[PLUGIN] " + sb);
        }
    }
}
