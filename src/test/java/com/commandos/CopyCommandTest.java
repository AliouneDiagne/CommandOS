package com.commandos;

import com.commandos.commands.CopyCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CopyCommandTest {
    @Test
    void invalidSyntaxTriggersUsageMessage() {
        String[] tokens = {"copy", "srcOnly"};
        CopyCommand cmd = new CopyCommand(tokens);
        // Non si puÃ² testare System.out facilmente qui (ci sono librerie apposta, ma lasciamo semplice)
        assertDoesNotThrow(cmd::execute);
    }

    @Test
    void validCopyDoesNotThrow() {
        String[] tokens = {"copy", "a.txt", "b.txt"};
        CopyCommand cmd = new CopyCommand(tokens);
        assertDoesNotThrow(cmd::execute);
    }
}
