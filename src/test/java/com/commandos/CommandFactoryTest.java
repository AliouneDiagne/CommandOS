package com.commandos;

import com.commandos.core.Command;
import com.commandos.core.factory.CommandFactory;
import com.commandos.commands.HelpCommand;
import com.commandos.commands.UnknownCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandFactoryTest {
    @Test
    void buildsHelpCommand() {
        Command cmd = CommandFactory.build("help");
        assertTrue(cmd instanceof HelpCommand);
    }

    @Test
    void buildsUnknownCommand() {
        Command cmd = CommandFactory.build("abracadabra");
        assertTrue(cmd instanceof UnknownCommand);
    }
}
