package util;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileLoggerTest {

    private static final String LOG_FILE = "log.txt";

    @Test
    public void testLogException_createsLogFileAndWritesStackTrace() throws IOException {
        // Delete log file if it exists to test from scratch
        Files.deleteIfExists(Paths.get(LOG_FILE));

        FileLogger logger = new FileLogger();

        try {
            throw new IllegalArgumentException("Test exception");
        } catch (Exception e) {
            logger.logException(e);
        }

        // Verify log file exists
        assertTrue(Files.exists(Paths.get(LOG_FILE)));

        // Verify log file contains the exception class name and message
        List<String> lines = Files.readAllLines(Paths.get(LOG_FILE));
        boolean containsStackTrace = lines.stream()
                .anyMatch(line -> line.contains("java.lang.IllegalArgumentException") && line.contains("Test exception"));
        assertTrue("Log file should contain the exception stack trace", containsStackTrace);
    }
}
