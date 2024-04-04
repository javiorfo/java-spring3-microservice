package com.orfosys.common.security;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtAuthConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    @Value("${jwt.keycloak.client-id}")
    private String keycloakClientId;

    @Override
    @SuppressWarnings("unchecked")
    public AbstractAuthenticationToken convert(Jwt jwt) {
        if (jwt.getClaim("resource_access") != null) {
            Map<String, Object> resourceAccess = jwt.getClaim("resource_access");
            Map<String, Object> client = (Map<String, Object>) resourceAccess.get(keycloakClientId);
            List<String> keycloakRoles = new ObjectMapper().convertValue(client.get("roles"),
                    new TypeReference<List<String>>() {});
            List<GrantedAuthority> roles = keycloakRoles.stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                    .collect(Collectors.toList());

            return new JwtAuthenticationToken(jwt, roles);
        }
        log.error("No roles assigned");
        return new JwtAuthenticationToken(jwt, Collections.emptyList());
    }
}
