package com.commandos.ui;

import com.commandos.strategy.AsyncStrategy;

/**
 * Entry-point principale dell’applicazione CommandOS CLI.
 */
public class ShellLauncher {
    public static void main(String[] args) {
        Shell shell = new Shell();
        // Esempio: se vuoi async puoi passare un flag "--async"
        if (args.length > 0 && "--async".equals(args[0])) {
            shell.setStrategy(new AsyncStrategy());
        }
        shell.start();
    }
}
