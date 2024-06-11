package com.pi.Services.JWT;

import com.pi.Models.UserModel;
import com.pi.Repositories.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class JWTService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    UserRepository userRepository;

    @Autowired
    public JWTService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String createToken(UserModel user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .setSubject(user.getUserID().toString())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public UserModel getUserFromToken(String token) throws Exception {
        Jws<Claims> claims = Jwts.parser()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token);

        String userIdString = claims.getPayload().getSubject();
        UUID userId = UUID.fromString(userIdString);
        Optional<UserModel> userModelDB = userRepository.findById(userId);

        if(userModelDB.isEmpty()) throw new Exception("TOKEN INVALIDO");

        return userModelDB.get();

    }

    public UUID getUuidFromToken(String token) throws Exception {
        Jws<Claims> claims = Jwts.parser()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token);

        String userIdString = claims.getPayload().getSubject();
        UUID userId = UUID.fromString(userIdString);
        return userId;
    }

}
