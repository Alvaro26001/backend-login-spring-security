package com.login.otroLogin.service.impl;

import com.login.otroLogin.models.User;
import com.login.otroLogin.service.iface.IJwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Service
public class JwtImpl implements IJwtService {
    @Value("${security.jwt.minute-expiration}")
    private Long EXPIRATION_MIUTE;

    @Value("${security.jwt.secret-key}")
    private String SECRECT_KEY;

    @Override
    public String generateToken(User user, Map<String, Object> claims) {

        Date issuedAt = new Date(System.currentTimeMillis());
        Date expiration = new Date(issuedAt.getTime() + (EXPIRATION_MIUTE * 60 *1000));

        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(user.getUsername())
                .setIssuedAt(issuedAt)
                .setExpiration(expiration)
                .setHeaderParam(Header.TYPE,Header.JWT_TYPE)
                .signWith(generateKey())
                .compact();
    }



    @Override
    public String extractUsername(String jwt) {
        return extractAllClaims(jwt)
                .getSubject();
    }

    private Claims extractAllClaims(String jwt) {
        return Jwts
                .parserBuilder()
                .setSigningKey(generateKey())
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }

    private Key generateKey() {
        byte[] secrectAsByte = Decoders.BASE64.decode(SECRECT_KEY);
        return Keys.hmacShaKeyFor(secrectAsByte);
    }
}
