package com.commandos.core.factory;

import com.commandos.core.Command;
import com.commandos.commands.*;
import com.commandos.infra.InputSanitizer;
import com.commandos.infra.SingletonLogger;

import java.util.Locale;

/**
 * Factory Method per la creazione dei comandi.
 */
public final class CommandFactory {
    private static final SingletonLogger LOG = SingletonLogger.getInstance();

    private CommandFactory() {}

    /**
     * Crea un Command a partire da una riga CLI.
     */
    public static Command build(String input) {
        if (input == null || input.isBlank())
            return new InvalidCommand("Empty command.");
        String clean = InputSanitizer.clean(input);
        String[] tokens = clean.strip().split("\\s+");
        String keyword = tokens[0].toLowerCase(Locale.ROOT);

        try {
            return switch (keyword) {
                case "help"    -> new HelpCommand();
                case "copy"    -> new CopyCommand(tokens);
                case "move"    -> new MoveCommand(tokens);
                case "macro"   -> new com.commandos.core.composite.CompositeCommand(input);
                case "ls"      -> new LsCommand(tokens);
                case "cd"      -> new CdCommand(tokens);
                case "mkdir"   -> new MkdirCommand(tokens);
                case "cat"     -> new CatCommand(tokens);
                case "rm"      -> new RmCommand(tokens);
                case "touch"   -> new TouchCommand(tokens);
                case "echo"    -> new EchoCommand(tokens);
                case "history" -> new HistoryCommand();
                default        -> new UnknownCommand(keyword);
            };
        } catch (Exception e) {
            LOG.error("Error building command: " + input, e);
            return new InvalidCommand("Command error: " + e.getMessage());
        }
    }
}
