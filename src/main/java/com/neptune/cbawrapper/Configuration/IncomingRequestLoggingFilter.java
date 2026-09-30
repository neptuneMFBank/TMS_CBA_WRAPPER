package com.neptune.cbawrapper.Configuration;

import com.neptune.cbawrapper.Controllers.AdminController;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class IncomingRequestLoggingFilter  extends OncePerRequestFilter {
    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        CachedBodyHttpServletRequest wrappedRequest =
                new CachedBodyHttpServletRequest(request);

        String payload = new String(
                wrappedRequest.getCachedBody(),
                StandardCharsets.UTF_8
        );

        log.info(
                "Incoming Request | Method: {} | URL: {} | Payload: {}",
                request.getMethod(),
                getFullUrl(request),
                payload
        );

        filterChain.doFilter(wrappedRequest, response);
    }

    private String getFullUrl(HttpServletRequest request) {

        String queryString = request.getQueryString();

        return queryString == null
                ? request.getRequestURL().toString()
                : request.getRequestURL() + "?" + queryString;
    }
}
