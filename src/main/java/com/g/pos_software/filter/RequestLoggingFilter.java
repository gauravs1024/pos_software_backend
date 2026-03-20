package com.g.pos_software.filter;
import com.g.pos_software.logger.RequestLogger;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Order(1) // run before JWT
public class RequestLoggingFilter extends OncePerRequestFilter {

    private final RequestLogger requestLogger;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        requestLogger.logRequest(
                request.getMethod(),
                request.getRequestURI(),
                "N/A"
        );

        requestLogger.logHeaders(request.getHeader("Authorization"));

        filterChain.doFilter(request, response);
    }
}