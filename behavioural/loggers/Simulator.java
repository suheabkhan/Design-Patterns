package behavioural.loggers;


import java.io.IOException;

/**
 * Design Logging Framework
 * Support multiple levels of loggers (ERROR,INFO,DEBUG,WARN,FATAL)
 * Should support certain categories of logs to a destination
 * 1. ERROR logs to be written on a local file
 * 2. INFO logs should be printed on console
 * System should be configurable enough, so that logs can be written/printed on users choice of destination
 * There should be support for the loggers where it can be sent to multiple logger destinations
 */

public class Simulator {
    public static void main(String[] args) throws IOException {
     CustomLogger logger = LoggerFactory.getLogger();
     logger.log("Value of a is 10",LogLevel.INFO);
     logger.log("Value of a is even number",LogLevel.DEBUG);
     logger.log("An error occured while querying DB",LogLevel.ERROR);
    }
}
