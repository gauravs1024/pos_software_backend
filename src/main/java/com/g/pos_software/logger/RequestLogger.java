package com.g.pos_software.logger;

public interface RequestLogger {
    void logRequest(String method, String uri, String body);

    void logHeaders(String authorization);

    void logError(String message);
}
