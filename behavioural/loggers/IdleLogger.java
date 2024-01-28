package behavioural.loggers;

public class IdleLogger implements CustomLogger{
    // This is the end logger, it will not publish any loggers
    @Override
    public void log(String message, LogLevel logLevel) {
       return;
    }
}
