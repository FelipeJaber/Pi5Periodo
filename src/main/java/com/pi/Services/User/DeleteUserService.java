package com.pi.Services.User;

import com.pi.Records.User.DeleteUserRecord;
import com.pi.Repositories.UserRepository;
import com.pi.Session.UserSessionSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserService {

    UserRepository userRepository;

    @Autowired
    public DeleteUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void deleteUser(DeleteUserRecord deleteUserRecord) throws Exception{
        authenticateUser(deleteUserRecord);
        userRepository.delete(UserSessionSingleton.getInstance().getUserModel());
    }

    private void authenticateUser(DeleteUserRecord deleteUserRecord) throws Exception {
        UserSessionSingleton session = UserSessionSingleton.getInstance();
        session.authenticateByToken(deleteUserRecord.token());
    }

}
