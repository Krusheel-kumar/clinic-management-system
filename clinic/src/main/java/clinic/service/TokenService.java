package clinic.service;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private static final String SECRET = "mysecretkey";

    public String generateToken(String email) {
        return email + "_token";
    }

    public boolean validateToken(String token) {
        return token != null && token.contains("_token");
    }
}
