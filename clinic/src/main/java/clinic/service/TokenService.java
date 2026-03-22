package clinic.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class TokenService {

    private static final String SECRET = "mysecretkeymysecretkeymysecretkey12345";

    // ✅ Generate JWT token
    public String generateToken(String user) {
        return Jwts.builder()
                .setSubject(user)
                .setIssuedAt(new Date()) // issued time
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour expiry
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // ✅ Signing key method (IMPORTANT)
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    // ✅ Validate token (bonus)
    public boolean validateToken(String token, String user) {
        String extractedUser = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();

        return extractedUser.equals(user);
    }
}
