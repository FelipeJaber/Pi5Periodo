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

        if (cpf.length() != 11) {
            return false;
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        char dig10, dig11;
        int sum, i, result, character, weight;

        sum = 0;
        weight = 10;
        for (i = 0; i < 9; i++) {
            character = cpf.charAt(i) - 48;
            sum = sum + (character * weight);
            weight = weight - 1;
        }
        result = 11 - (sum % 11);
        if ((result == 10) || (result == 11)) {
            dig10 = '0';
        } else {
            dig10 = (char) (result + 48);
        }

        sum = 0;
        weight = 11;
        for (i = 0; i < 10; i++) {
            character = cpf.charAt(i) - 48;
            sum = sum + (character * weight);
            weight = weight - 1;
        }
        result = 11 - (sum % 11);
        if ((result == 10) || (result == 11)) {
            dig11 = '0';
        } else {
            dig11 = (char) (result + 48);
        }

        return (dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10));
    }

    @Override
    public String formatCpf(String cpf) throws Exception {
        return cpf.replaceAll("[^\\d]", "");
    }

    @Override
    public void verifyIfCPFAlreadyRegistered(String cpf) throws Exception {
        Optional<UserModel> userdb = userRepository.findByCpf(cpf);
        if(userdb.isPresent())throw new Exception("CPF JA CADASTRADO");
    }
}
