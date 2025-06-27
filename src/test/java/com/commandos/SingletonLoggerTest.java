package com.commandos;

import com.commandos.infra.SingletonLogger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingletonLoggerTest {
    @Test
    void loggerIsSingletonAndDoesNotThrow() {
        SingletonLogger logger1 = SingletonLogger.getInstance();
        SingletonLogger logger2 = SingletonLogger.getInstance();
        assertSame(logger1, logger2);
        assertDoesNotThrow(() -> logger1.info("JUnit logger info test"));
        assertDoesNotThrow(() -> logger1.warn("JUnit logger warn test"));
        assertDoesNotThrow(() -> logger1.error("JUnit logger error test", new Exception("test")));
    }
}
