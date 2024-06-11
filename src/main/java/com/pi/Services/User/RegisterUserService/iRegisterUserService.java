package com.pi.Services.User.RegisterUserService;

import com.pi.Records.User.RegisterUserRecord;
import org.springframework.stereotype.Service;

@Service
public interface iRegisterUserService {
    String RegisterUser(RegisterUserRecord registerUserRecord) throws Exception;
}
