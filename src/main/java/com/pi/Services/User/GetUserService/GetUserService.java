package com.pi.Services.User.GetUserService;

import com.pi.Records.User.GetUserRecord;
import com.pi.Services.JWT.JWTServices;
import com.pi.Services.JWT.iJWTServices;
import com.pi.Session.UserSessionSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetUserService implements iGetUserService{

    iJWTServices jwtService;

    @Autowired
    public GetUserService(JWTServices jwtService) {
        this.jwtService = jwtService;
    }

    public String getUser(GetUserRecord getUserRecord) throws Exception {
        authenticateUser(getUserRecord);
        return jwtService.createToken(UserSessionSingleton.getInstance().getUserModel());
    }

    private void authenticateUser(GetUserRecord getUserRecord) throws Exception {
        UserSessionSingleton session = UserSessionSingleton.getInstance();
        session.authenticateByCpfAndPassWord(getUserRecord.cpf(),getUserRecord.passWord());
    }

}
