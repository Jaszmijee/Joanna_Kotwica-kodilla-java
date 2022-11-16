package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoggerTestSuite {

    private static Logger logger = Logger.RECORD;

    @BeforeAll
    public static void addLog() {
        logger.log("11.1");
    }

    @Test
    public void testGetLastLog() {
        assertNotNull(logger.getLastLog());
        assertEquals("11.1", logger.getLastLog());
    }
}
