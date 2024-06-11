package com.pi.Services.User.GetUserService;

import com.pi.Records.User.GetUserRecord;
import org.springframework.stereotype.Service;

@Service
public interface iGetUserService {
    String getUser(GetUserRecord getUserRecord) throws Exception;
}
