package com.g.pos_software.logger.impl;

import com.g.pos_software.logger.AppLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
public class AppLoggerImpl implements AppLogger {

    private final Logger log = LoggerFactory.getLogger(AppLoggerImpl.class);

    // ANSI Color Constants
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";

    @Override
    public void info(String message) {
        log.info(format(ANSI_GREEN + "LOGGER" + ANSI_RESET, message));
    }

    @Override
    public void debug(String message) {
        log.debug(format(ANSI_CYAN + "DEBUG" + ANSI_RESET, message));
    }

    @Override
    public void error(String message, Throwable throwable) {
        log.error(format(ANSI_RED + "ERROR" + ANSI_RESET, message), throwable);
    }

    @Override
    public void custom(String tag, String message) {
        log.info(format(ANSI_YELLOW + tag + ANSI_RESET, message));
    }

    private String format(String level, String message) {
        // This will print the level in color and the message in default white/gray
        return String.format("[%s] %s", level, message);
    }
}