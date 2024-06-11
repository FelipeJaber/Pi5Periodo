package com.pi.Services.User;

import com.pi.Models.UserModel;
import com.pi.Records.User.RegisterUserRecord;
import com.pi.Repositories.UserRepository;
import com.pi.Services.JWT.JWTService;
import com.pi.Services.Validations.Cpf.CpfValidationService;
import com.pi.Services.Validations.Cpf.iCpfValidationService;
import com.pi.Services.Validations.Phone.PhoneValidationService;
import com.pi.Services.Validations.Phone.iPhoneValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {

    UserRepository userRepository;
    JWTService jwtService;
    iCpfValidationService cpfValidationService;
    iPhoneValidationService phoneValidationService;

    @Autowired
    public RegisterUserService(UserRepository userRepository, JWTService jwtService, CpfValidationService cpfValidationService, PhoneValidationService phoneValidationService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.cpfValidationService = cpfValidationService;
        this.phoneValidationService = phoneValidationService;
    }

    public String RegisterUser(RegisterUserRecord registerUserRecord) throws Exception {

        verifyEntryes(registerUserRecord);

        UserModel userModel = new UserModel(registerUserRecord);
        userRepository.save(userModel);
        return jwtService.createToken(userModel);
    }

    private void verifyEntryes(RegisterUserRecord registerUserRecord) throws Exception{
        String formattedPhone = phoneValidationService.formatPhone(registerUserRecord.phone());
        phoneValidationService.verifyIfPhoneIsValid(formattedPhone);
        phoneValidationService.verifyIfPhoneAlreadyRegistered(formattedPhone);

        String formattedCpf = cpfValidationService.formatCpf(registerUserRecord.cpf());
        cpfValidationService.verifyIfCpfIsValid(formattedCpf);
        cpfValidationService.verifyIfCPFAlreadyRegistered(formattedCpf);
    }



}
