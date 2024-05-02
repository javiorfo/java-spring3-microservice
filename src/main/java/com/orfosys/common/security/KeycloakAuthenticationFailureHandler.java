package com.orfosys.common.security;

import java.io.OutputStream;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orfosys.common.response.RestResponseError;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KeycloakAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    @SneakyThrows
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) {
        var restResponseHeader = new RestResponseError(
                List.of(new RestResponseError.Error(HttpStatus.INTERNAL_SERVER_ERROR, "AUTH_FAILED",
                        "Authentication failure.")));
        log.error("Authentication failure");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        OutputStream responseStream = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(responseStream, restResponseHeader);
        responseStream.flush();
    }
}
