package com.commandos.commands;

import com.commandos.core.Command;

/**
 * Stampa l'elenco dei comandi disponibili.
 */
public class HelpCommand implements Command {
    @Override
    public void execute() {
        System.out.println("""
            === CommandOS Commands ===
            help           Show this help
            ls             List files/dirs
            cd <dir>       Change directory
            mkdir <name>   Create directory
            cat <file>     Show file content
            copy <src> <dest>  Copy file
            move <src> <dest>  Move file
            rm <file>      Remove file
            echo <text>    Print text
            history        Show command history
            """);
    }
}
