package behavioural.loggers;

import java.io.IOException;

public class LoggerFactory {
    private LoggerFactory(){}

    public static CustomLogger getLogger() throws IOException {

        // For DEBUG and INFO type, configure only to be printed on console
        // FOR WARN AND ERROR type, configure to be printed on console and Filw

        // IN real time, this configuration is to be read from a file

        Publisher debugInfoPublisher = new LogPublisher();
        debugInfoPublisher.subscribe(new ConsoleSubscriber());

        Publisher warnAndAbovePublisher = new LogPublisher();
        warnAndAbovePublisher.subscribe(new ConsoleSubscriber());
        warnAndAbovePublisher.subscribe(new FileSubscriber("log.txt"));

        return new DebugLogger(
                    new InfoLogger(
                        new WarnLogger(
                                new ErrorLogger(
                                        new IdleLogger(),
                                        warnAndAbovePublisher),
                                warnAndAbovePublisher),
                        debugInfoPublisher),
                debugInfoPublisher);
    }
}
