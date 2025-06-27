package com.commandos;

import com.commandos.core.Command;
import com.commandos.core.composite.CompositeCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CliMacroTest {
    @Test
    void testMacroParsesAndExecutesAll() {
        String input = "macro echo one | echo two | echo three";
        CompositeCommand macro = new CompositeCommand(input);
        assertEquals(3, macro.getSubCommands().size());
        // L'esecuzione non lancia eccezioni
        assertDoesNotThrow(macro::execute);
    }
}
