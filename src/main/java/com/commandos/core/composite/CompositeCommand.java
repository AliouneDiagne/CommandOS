package com.commandos.core.composite;

import com.commandos.core.Command;
import com.commandos.core.factory.CommandFactory;
import com.commandos.infra.InputSanitizer;
import com.commandos.infra.SingletonLogger;

import java.util.ArrayList;
import java.util.List;

/**
 * Macro-comando composto da una sequenza di altri comandi.
 * Pattern: Composite.
 */
public class CompositeCommand implements Command {
    private final List<Command> commands = new ArrayList<>();
    private final String rawInput;
    private static final SingletonLogger LOG = SingletonLogger.getInstance();

    public CompositeCommand(String input) {
        this.rawInput = input;
        parseMacro(input);
    }

    private void parseMacro(String input) {
        String sanitized = InputSanitizer.clean(input);
        String[] chunks = sanitized.replaceFirst("(?i)macro", "").strip().split("\\|");
        for (String chunk : chunks) {
            Command cmd = CommandFactory.build(chunk.strip());
            commands.add(cmd);
        }
        LOG.info("Macro parsed into " + commands.size() + " commands.");
    }

    @Override
    public void execute() {
        LOG.info("Executing macro: " + rawInput);
        for (Command cmd : commands) {
            cmd.execute();
        }
        LOG.info("Macro completed.");
    }

    public List<Command> getSubCommands() {
        return List.copyOf(commands);
    }
}
