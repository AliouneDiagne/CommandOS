package com.commandos;

import com.commandos.commands.MkdirCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MkdirCommandTest {
    @Test
    void mkdirWithNoArgShowsUsage() {
        String[] tokens = {"mkdir"};
        MkdirCommand cmd = new MkdirCommand(tokens);
        assertDoesNotThrow(cmd::execute);
    }

    @Test
    void mkdirWithNameDoesNotThrow() {
        String[] tokens = {"mkdir", "testdir"};
        MkdirCommand cmd = new MkdirCommand(tokens);
        assertDoesNotThrow(cmd::execute);
    }
}
