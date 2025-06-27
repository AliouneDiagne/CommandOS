package com.commandos;

import com.commandos.ui.Shell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShellTest {
    @Test
    void historyInitiallyEmpty() {
        Shell shell = new Shell();
        assertTrue(shell.history().isEmpty());
    }
}
