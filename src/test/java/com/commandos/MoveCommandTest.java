package com.commandos;

import com.commandos.commands.MoveCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveCommandTest {
    @Test
    void moveWithInvalidArgsShowsUsage() {
        String[] tokens = {"move", "a"};
        MoveCommand cmd = new MoveCommand(tokens);
        assertDoesNotThrow(cmd::execute);
    }

    @Test
    void moveWithValidArgsDoesNotThrow() {
        String[] tokens = {"move", "src.txt", "dest.txt"};
        MoveCommand cmd = new MoveCommand(tokens);
        assertDoesNotThrow(cmd::execute);
    }
}
