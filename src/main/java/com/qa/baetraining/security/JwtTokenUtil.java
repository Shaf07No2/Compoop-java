package com.qa.baetraining.security;

import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
// import io.jsonwebtoken.security.MacAlgorithm;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.Key;
// import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

@Component
public class JwtTokenUtil implements Serializable {

    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    Dotenv dotenv = Dotenv.load();
    // SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(dotenv.get("ACCESS_TOKEN_SECRET")));

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public String getEmailFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Long getUserIdString(String token) {
        Claims claim = Jwts.parserBuilder().setSigningKey(dotenv.get("ACCESS_TOKEN_SECRET")).build().parseClaimsJws(token).getBody();

        Object requesterIdObj = claim.get("userId");
        if (requesterIdObj != null) {
            String requesterId = requesterIdObj.toString();
            long formattedRequesterId = Long.parseLong(requesterId);
            return formattedRequesterId;
        } else {
            System.out.println("requesterObject from claim is null");
            return null;
        }

        // Extract the userId from the token
        // String requesterId = (String) claim.get("userId");
        // long formattedRequesterId = Long.parseLong(requesterId);
        // return formattedRequesterId;
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(dotenv.get("ACCESS_TOKEN_SECRET")).build().parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    // public String generateToken(UserDetails userDetails) {
    //     Map<String, Object> claims = new HashMap<>();
    //     return Jwts.builder().setClaims(claims)
    //                 .claim("sub", userDetails.getUsername())
    //                 .claim("iat", new Date())
    //                 .claim("exp", new Date(System.currentTimeMillis() + 86400000))
    //                 .signWith(key)
    //                 .compact();
    // }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder().setClaims(claims)
                    .claim("sub", userDetails.getUsername())
                    .claim("iat", new Date())
                    .claim("exp", new Date(System.currentTimeMillis() + 86400000))
                    .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(dotenv.get("ACCESS_TOKEN_SECRET"))))
                    .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}