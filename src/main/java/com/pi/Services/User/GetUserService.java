package com.pi.Services.User;

import com.pi.Records.User.GetUserRecord;
import com.pi.Services.JWT.JWTService;
import com.pi.Session.UserSessionSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetUserService {

    JWTService jwtService;

    @Autowired
    public GetUserService(JWTService jwtService) {
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
