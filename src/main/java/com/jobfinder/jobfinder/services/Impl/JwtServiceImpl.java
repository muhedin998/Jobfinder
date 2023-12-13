package com.jobfinder.jobfinder.services.Impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.aspectj.weaver.patterns.IToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.security.auth.Subject;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServiceImpl {

    private static final String PRIVATE_KEY = "3cd5db3d58da338fc6403b179c5e2cdedc55cebb631c33c65eccc7d5f12c2b7b";
    public String extractUsername(String jwt) {
        return extractClaims(jwt, Claims::getSubject);
    }

    public <T> T extractClaims (String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken (Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()  + 1000 * 60 * 24))
                .signWith(getSigningKeys(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid (String token,UserDetails  userDetails) {
        final String username = userDetails.getUsername();
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExipration(token).before(new Date());
    }

    private Date extractExipration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }

    private Claims extractAllClaims (String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKeys())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSigningKeys() {
        byte[] keyBytes = Decoders.BASE64.decode(PRIVATE_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
