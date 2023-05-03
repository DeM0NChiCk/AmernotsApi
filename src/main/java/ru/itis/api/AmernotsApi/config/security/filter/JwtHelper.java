package ru.itis.api.AmernotsApi.config.security.filter;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.Instant;

@Component
@Slf4j
public class JwtHelper {
    @Value("${jwt.secret}")
    private String jwtSecret;

    public String generateToken(JwtClaims jwtClaims) {
        Claims claims = Jwts.claims();
        claims.put("id", jwtClaims.getId());
        claims.put("password", jwtClaims.getPassword());
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .setExpiration(Date.from(Instant.now().plusSeconds(24 * 60 * 60)))
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException expEx) {
            log.error("Token expired");
        } catch (UnsupportedJwtException unsEx) {
            log.error("Unsupported jwt");
        } catch (MalformedJwtException mjEx) {
            log.error("Malformed jwt");
        } catch (SignatureException sEx) {
            log.error("Invalid signature");
        } catch (Exception e) {
            log.error("invalid token");
        }
        return false;
    }

    public JwtClaims getDataFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return JwtClaims.builder()
                .id((Long) claims.get("id"))
                .password((String) claims.get("password"))
                .build();
    }
}
