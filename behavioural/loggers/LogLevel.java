package behavioural.loggers;

// Should support the multi-level logs
public enum LogLevel {
    DEBUG(0),
    INFO(1),
    WARN(2),
    ERROR(3),
    FATAL(4);
    private final int level;

    public int getLevel() {
        return level;
    }

    LogLevel(int level) {
        this.level = level;
    }
}
