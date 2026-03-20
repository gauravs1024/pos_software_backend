package com.g.pos_software.logger.impl;

import com.g.pos_software.logger.RequestLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class RequestLoggerImpl implements RequestLogger {
    private static final Logger log = LoggerFactory.getLogger(RequestLoggerImpl.class);

    @Override
    public void logRequest(String method, String uri, String body) {
        log.info("Request → {} {}", method, uri);
        log.info("Body → {}", body);
    }

    @Override
    public void logHeaders(String authorization) {
        log.info("Authorization Header → {}", authorization);
    }

    @Override
    public void logError(String message) {
        log.error("Error → {}", message);
    }
}
