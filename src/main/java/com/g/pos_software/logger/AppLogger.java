package com.g.pos_software.logger;

public interface AppLogger {

    void info(String message);

    void debug(String message);

    void error(String message, Throwable throwable);

    void custom(String tag, String message);
}