package com.commandos.commands;

import com.commandos.core.Command;
import com.commandos.fs.DirComposite;
import com.commandos.fs.FsNode;

/**
 * Lista contenuto directory corrente.
 */
public class LsCommand implements Command {
    private final String[] tokens;

    public LsCommand(String[] tokens) {
        this.tokens = tokens;
    }

    @Override
    public void execute() {
        // In reale: passare DirComposite corrente (qui demo su root vuoto)
        DirComposite root = new DirComposite("/");
        if (root.getChildren().isEmpty()) {
            System.out.println("[empty]");
            return;
        }
        for (FsNode node : root.getChildren()) {
            System.out.println((node.isDirectory() ? "[D] " : "[F] ") + node.getName());
        }
    }
}
