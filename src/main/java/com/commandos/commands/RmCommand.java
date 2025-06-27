package com.commandos.commands;

import com.commandos.core.Command;
import com.commandos.fs.DirComposite;
import com.commandos.fs.FsNode;
import com.commandos.infra.SingletonLogger;

/**
 * Rimuove file o directory virtuale: rm <name>
 */
public class RmCommand implements Command {
    private final String[] tokens;
    private static final SingletonLogger LOG = SingletonLogger.getInstance();

    public RmCommand(String[] tokens) {
        this.tokens = tokens;
    }

    @Override
    public void execute() {
        if (tokens.length != 2) {
            System.out.println("Usage: rm <name>");
            return;
        }
        DirComposite root = new DirComposite("/"); // TODO: FSContext
        FsNode node = root.find(tokens[1]);
        if (node != null) {
            root.remove(node);
            System.out.println("Removed: " + tokens[1]);
            LOG.info("rm command executed: " + tokens[1]);
        } else {
            System.out.println("File or directory not found: " + tokens[1]);
        }
    }
}
