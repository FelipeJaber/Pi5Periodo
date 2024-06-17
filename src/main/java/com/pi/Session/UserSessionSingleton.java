package com.pi.Session;

import com.pi.Models.UserModel;
import com.pi.Repositories.UserRepository;
import com.pi.Services.JWT.JWTServices;
import com.pi.Services.JWT.iJWTServices;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UserSessionSingleton {

    private static UserSessionSingleton instance;
    private UserModel userModel;
    private boolean authenticated;
    private final UserRepository userRepository;
    private final iJWTServices jwtService;

    @Autowired
    public UserSessionSingleton(UserRepository userRepository, JWTServices jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.authenticated = false;
    }

    @PostConstruct
    public void init() {
        instance = this;
    }

    public static synchronized UserSessionSingleton getInstance() {
        return instance;
    }

    public void authenticateByToken(String token) throws Exception {
        UUID userId = jwtService.getUuidFromToken(token);
        Optional<UserModel> dbUserModel = userRepository.findById(userId);

        if (dbUserModel.isEmpty()) throw new Exception("TOKEN INVALIDO");

        this.userModel = dbUserModel.get();
        this.authenticated = true;
    }

    public void authenticateByCpfAndPassWord(String cpf, String passWord) throws Exception {
        Optional<UserModel> dbUserModel = userRepository.findByCpf(cpf);

        if (dbUserModel.isEmpty()) throw new Exception("CPF NAO CADASTRADO");
        if (!dbUserModel.get().getPassWord().equals(passWord)) throw new Exception("SENHA INVALIDA");

        this.userModel = dbUserModel.get();
        this.authenticated = true;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }
}
