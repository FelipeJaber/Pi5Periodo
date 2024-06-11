package com.pi.Services.JWT;

import com.pi.Models.UserModel;
import java.util.UUID;

public interface iJWTServices {

    String createToken(UserModel user);

    UUID getUuidFromToken(String token) throws Exception;
}
