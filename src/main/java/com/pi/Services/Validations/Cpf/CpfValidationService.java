package com.pi.Services.Validations.Cpf;

import com.pi.Models.UserModel;
import com.pi.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CpfValidationService implements iCpfValidationService{

    UserRepository userRepository;

    @Autowired
    public CpfValidationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean verifyIfCpfIsValid(String cpf) throws Exception {
        return true;
    }

    @Override
    public String formatCpf(String cpf) throws Exception {
        return "";
    }

    @Override
    public void verifyIfCPFAlreadyRegistered(String cpf) throws Exception {
        Optional<UserModel> userdb = userRepository.findByCpf(cpf);
        if(userdb.isPresent())throw new Exception("CPF JA CADASTRADO");
    }
}
