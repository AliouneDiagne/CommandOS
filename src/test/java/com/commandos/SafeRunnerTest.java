package com.commandos;

import com.commandos.infra.errors.SafeRunner;
import com.commandos.core.Command;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SafeRunnerTest {

    @Test
    void testIllegalArgumentExceptionHandling() {
        Command failingCmd = () -> { throw new IllegalArgumentException("Invalid argument!"); };
        assertDoesNotThrow(() -> SafeRunner.run(failingCmd), "SafeRunner should handle IllegalArgumentException without throwing");
    }

    @Test
    void testGeneralExceptionHandling() {
        Command failingCmd = () -> { throw new RuntimeException("General failure!"); };
        assertDoesNotThrow(() -> SafeRunner.run(failingCmd), "SafeRunner should handle RuntimeException without throwing");
    }
}
