package com.insuranceapp.config;

import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        // to send error message to the client
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"UnAuthorized");
    }
}