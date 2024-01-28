package behavioural.loggers;

public class DebugLogger implements CustomLogger{

    //Each logger will have its next handler if in case, this doesnot handle it
    private final CustomLogger nextLogger;

    //Since we need to write the loggers into the destinations of choice,
    // we need logPublisher which will notify all its subscribers
    private final Publisher logPublisher;

    public DebugLogger(CustomLogger nextLogger, Publisher logPublisher) {
        this.nextLogger = nextLogger;
        this.logPublisher = logPublisher;
    }

    @Override
    public void log(String message, LogLevel logLevel) {
        if(logLevel.getLevel() == LogLevel.DEBUG.getLevel()){
            this.logPublisher.notify(LogLevel.DEBUG.getLevel()+" "+message);
        }
        this.nextLogger.log(message,logLevel);
    }
}
