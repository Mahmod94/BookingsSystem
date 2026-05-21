package com.hashim.BookingsSystem.service;

import com.hashim.BookingsSystem.exception.InvalidTokenException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {
    private final String secret = "I've_heard_he_spends_500_pounds_on_jeans_goes_to_the_gym_6_times_a_week_get_tatoos_he_" +
            "doesn't_even_know_what_it_means_but_i_heard_he_makes_you_happy_so_its_fine_by_my";
    private final Key key = Keys.hmacShaKeyFor(secret.getBytes());

    public String generateToken (String username) {
        return Jwts.builder().setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2 )) // 2 h
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String validateTokenAndGetUserName(String token){

        return Jwts.parser()
                .setSigningKey(key).build()
                .parseSignedClaims(token)
                .getBody().getSubject();
    }
}
