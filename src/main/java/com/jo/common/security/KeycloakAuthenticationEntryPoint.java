package com.jo.common.security;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jo.common.response.RestResponseHeader;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("keycloakAuthenticationEntryPoint")
public class KeycloakAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) 
      throws IOException, ServletException {

        // TODO trace
        var restResponseHeader = new RestResponseHeader("trace", List.of(new RestResponseHeader.Error("code", "desc")));
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        OutputStream responseStream = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(responseStream, restResponseHeader);
        responseStream.flush();
    }
}
