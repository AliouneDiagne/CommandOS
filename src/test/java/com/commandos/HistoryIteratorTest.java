package com.commandos;

import com.commandos.core.Command;
import com.commandos.core.HistoryIterator;
import com.commandos.commands.EchoCommand;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HistoryIteratorTest {
    @Test
    void iteratesAllCommandsInOrder() {
        List<Command> history = Arrays.asList(
            new EchoCommand(new String[]{"echo", "a"}),
            new EchoCommand(new String[]{"echo", "b"}),
            new EchoCommand(new String[]{"echo", "c"})
        );
        HistoryIterator it = new HistoryIterator(history);

        assertTrue(it.hasNext());
        assertNotNull(it.next());
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        assertFalse(it.hasNext());
    }
}
