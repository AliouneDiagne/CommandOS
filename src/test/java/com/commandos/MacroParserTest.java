package com.commandos;

import com.commandos.core.composite.CompositeCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MacroParserTest {
    @Test
    void parsesMultipleMacroChunks() {
        CompositeCommand macro = new CompositeCommand("macro echo a | echo b | echo c");
        assertEquals(3, macro.getSubCommands().size());
    }

    @Test
    void singleCommandMacroWorks() {
        CompositeCommand macro = new CompositeCommand("macro echo only");
        assertEquals(1, macro.getSubCommands().size());
    }
}
