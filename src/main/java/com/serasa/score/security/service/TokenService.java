package com.serasa.score.security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class TokenService {

    MyUserDetailsService myUserDetailsService;

    @Value("${jwt.expiration}")
    private String expiration;

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(Long userId) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("IRS")
                .setSubject(userId.toString())
                .setIssuedAt(new Date())
                .setExpiration(exp).signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getTokenId(String token) {
        Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return Long.valueOf(body.getSubject());
    }

}
