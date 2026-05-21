package com.hashim.BookingsSystem.component;

import com.hashim.BookingsSystem.exception.InvalidTokenException;
import com.hashim.BookingsSystem.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    private JwtService jwtService;
    private UserDetailsService userDetailsService;

    public JwtRequestFilter(JwtService jwtService,@Lazy UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try
        {
            String authHeader = request.getHeader("Authorization");
            if (authHeader != null && authHeader.startsWith("Bearer ")){
                String token = authHeader.substring(7);

                String username = jwtService.validateTokenAndGetUserName(token);

                if (username != null)
                {
                    UserDetails user = userDetailsService.loadUserByUsername(username);

                    // Intern token som används intern av spring security
                    var authToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        } catch (InvalidTokenException e)
        {
            throw new InvalidTokenException(e.getMessage());
        }
        filterChain.doFilter(request, response);
    }
}
