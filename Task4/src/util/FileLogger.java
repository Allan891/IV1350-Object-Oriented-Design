package util;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A simple logger that writes exception stack traces to a log file.
 */
public class FileLogger {
    private PrintWriter logStream;

    public FileLogger() {
        try {
            logStream = new PrintWriter(new FileWriter("log.txt", true)); // append mode
        } catch (IOException e) {
            System.out.println("Could not open log file.");
        }
    }

    /**
     * Logs the exception by printing the stack trace to the log file.
     *
     * @param e The exception to log.
     */
    public void logException(Exception e) {
        e.printStackTrace(logStream);
        logStream.println();
        logStream.flush();
    }
}
