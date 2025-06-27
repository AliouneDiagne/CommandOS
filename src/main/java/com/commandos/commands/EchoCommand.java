package com.commandos.commands;

import com.commandos.core.Command;

/**
 * Stampa a video una stringa: echo <text>
 */
public class EchoCommand implements Command {
    private final String[] tokens;

    public EchoCommand(String[] tokens) {
        this.tokens = tokens;
    }

    @Override
    public void execute() {
        if (tokens.length < 2) {
            System.out.println();
        } else {
            // Unisci tutti i token tranne il primo
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < tokens.length; i++) {
                sb.append(tokens[i]);
                if (i < tokens.length - 1) sb.append(" ");
            }
            System.out.println(sb);
        }
    }
}
