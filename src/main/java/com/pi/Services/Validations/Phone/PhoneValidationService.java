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
        if (phone.length() == 10 || phone.length() == 11) {

            if (phone.charAt(0) == '0') {
                phone = phone.substring(1);
            }

            String ddd = phone.substring(0, 2);
            int dddNumber = Integer.parseInt(ddd);
            if (dddNumber >= 1 && dddNumber <= 99) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String formatPhone(String phone) throws Exception {
        return phone.replaceAll("[^\\d]", "");
    }

    @Override
    public void verifyIfPhoneAlreadyRegistered(String phone) throws Exception {
        Optional<UserModel> userdb = userRepository.findByPhone(phone);
        if(userdb.isPresent())throw new Exception("NUMERO DE TELEFONE JA CADASTRADO");
    }
}
