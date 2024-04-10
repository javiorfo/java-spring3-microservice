package com.orfosys.common.security;

import java.io.OutputStream;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orfosys.common.response.RestResponseHeader;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KeycloakAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    @SneakyThrows
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException) {
        var restResponseHeader = new RestResponseHeader(
                List.of(new RestResponseHeader.Error(HttpStatus.INTERNAL_SERVER_ERROR, "ACCESS_DENIED",
                        "Access denied to this resource.")));
        log.error("Access denied");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        OutputStream responseStream = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(responseStream, restResponseHeader);
        responseStream.flush();
    }
}
