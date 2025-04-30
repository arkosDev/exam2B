
package com.iarcos.b2.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoggInterceptor implements org.springframework.web.servlet.HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        LOGGER.info("Header:");
        request.getHeaderNames().asIterator().forEachRemaining(headerName ->
            LOGGER.info("{}: {}", headerName, request.getHeader(headerName))
        );
        return true; 
    }
}
