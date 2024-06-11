package com.pi.Services.User.DeleteUserService;

import com.pi.Records.User.DeleteUserRecord;
import org.springframework.stereotype.Service;

@Service
public interface iDeleteUserService {
    void deleteUser(DeleteUserRecord deleteUserRecord) throws Exception;
}
