package com.pi.Services.User.UpdateUserService;

import com.pi.Records.User.UpdateUserRecord;
import org.springframework.stereotype.Service;

@Service
public interface iUpdateUserService {
    public void updateUser(UpdateUserRecord updateUserRecord) throws Exception;
}
