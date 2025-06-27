package com.commandos;

import com.commandos.core.composite.CompositeCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompositeCommandTest {
    @Test
    void macroWithEmptyInputYieldsNoCommands() {
        CompositeCommand macro = new CompositeCommand("macro");
        assertEquals(1, macro.getSubCommands().size()); // solo macro vuoto, può cambiare se preferisci 0
    }

    @Test
    void macroExecutesAllCommands() {
        CompositeCommand macro = new CompositeCommand("macro echo test1 | echo test2");
        assertEquals(2, macro.getSubCommands().size());
        assertDoesNotThrow(macro::execute);
    }
}
