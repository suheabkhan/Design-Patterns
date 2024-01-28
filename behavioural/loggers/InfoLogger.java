package behavioural.loggers;

public class InfoLogger implements CustomLogger{

    //Each logger will have its next handler if in case, this doesnot handle it
    private final CustomLogger nextLogger;

    //Since we need to write the loggers into the destinations of choice,
    // we need logPublisher which will notify all its subscribers
    private final Publisher logPublisher;

    public InfoLogger(CustomLogger nextLogger, Publisher logPublisher) {
        this.nextLogger = nextLogger;
        this.logPublisher = logPublisher;
    }

    @Override
    public void log(String message, LogLevel logLevel) {
        // Here we will check, if the loglevel of incoming logger is same as that of the error logger
        //if same process
        //else let the nextLogger handle it
        if(logLevel.getLevel()==LogLevel.INFO.getLevel()){
            this.logPublisher.notify(LogLevel.INFO.getLevel()+" "+message);
        }
        this.nextLogger.log(message,logLevel);
    }
}
