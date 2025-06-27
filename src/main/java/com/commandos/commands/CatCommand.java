package com.commandos.commands;

import com.commandos.core.Command;
import com.commandos.fs.DirComposite;
import com.commandos.fs.FsNode;
import com.commandos.fs.FileLeaf;
import com.commandos.infra.SingletonLogger;

/**
 * Visualizza il contenuto di un file virtuale: cat <filename>
 */
public class CatCommand implements Command {
    private final String[] tokens;
    private static final SingletonLogger LOG = SingletonLogger.getInstance();

    public CatCommand(String[] tokens) {
        this.tokens = tokens;
    }

    @Override
    public void execute() {
        if (tokens.length != 2) {
            System.out.println("Usage: cat <filename>");
            return;
        }
        // Assume root dir (in reale: passare cwd, qui esempio base)
        DirComposite root = new DirComposite("/"); // TODO: integra con FSContext
        FsNode node = root.find(tokens[1]);
        if (node instanceof FileLeaf file) {
            System.out.println(file.getContent());
        } else {
            System.out.println("File not found: " + tokens[1]);
        }
        LOG.info("cat command executed on " + tokens[1]);
    }
}
