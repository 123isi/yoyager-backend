package org.example.yoyager_backend.global;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtProvider {

  @Value("${jwt.secret-key}")
  private String secretKey;

  private static final long Time = 1000 * 60 * 60;

  public String generateToken(Long id, String name, String email, String birthdate) {
    Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

    return Jwts.builder()
            .claim("id", id)
            .claim("name", name)
            .claim("email", email)
            .claim("birthdate", birthdate)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + Time))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
  }

}
