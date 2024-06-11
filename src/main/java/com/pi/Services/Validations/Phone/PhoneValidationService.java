package com.pi.Services.Validations.Phone;

import com.pi.Models.UserModel;
import com.pi.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhoneValidationService implements iPhoneValidationService{

    UserRepository userRepository;

    @Autowired
    public PhoneValidationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean verifyIfPhoneIsValid(String phone) throws Exception {
        return true;
    }

    @Override
    public String formatPhone(String phone) throws Exception {
        return "";
    }

    @Override
    public void verifyIfPhoneAlreadyRegistered(String phone) throws Exception {
        Optional<UserModel> userdb = userRepository.findByPhone(phone);
        if(userdb.isPresent())throw new Exception("NUMERO DE TELEFONE JA CADASTRADO");
    }
}
