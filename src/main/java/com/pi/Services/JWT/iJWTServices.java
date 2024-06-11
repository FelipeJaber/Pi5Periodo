package com.pi.Services.JWT;

import com.pi.Models.UserModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.UUID;

public interface iJWTServices {

    public String createToken(UserModel user);

    public UUID getUuidFromToken(String token) throws Exception;
}
