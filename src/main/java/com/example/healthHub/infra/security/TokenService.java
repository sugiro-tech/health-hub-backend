package com.example.healthHub.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.healthHub.models.UserClientModel;
import com.example.healthHub.models.UserProfessionalModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;
    public String generateToken(UserClientModel user){
    try{
        Algorithm algorithm = Algorithm.HMAC256(secret);
        String token = JWT.create()
                .withIssuer("health-hub")
                .withSubject(user.getEmail())
                .withClaim("email",user.getName())
                .withClaim("userId", user.getId())
                .withExpiresAt(getExpirationDate())
                .sign(algorithm);
        return token;
    }catch (JWTCreationException exception){
        throw new RuntimeException("Error while generating token", exception);
    }
    }
    public String generateTokenProfessional(UserProfessionalModel user){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("health-hub")
                    .withSubject(user.getEmail())
                    .withClaim("email",user.getName())
                    .withClaim("userId", user.getId())
                    .withExpiresAt(getExpirationDate())
                    .sign(algorithm);
            return token;
        }catch (JWTCreationException exception){
            throw new RuntimeException("Error while generating token", exception);
        }
    }
    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("health-hub")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException exception){
            return "";
        }
    }

    private Instant getExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
