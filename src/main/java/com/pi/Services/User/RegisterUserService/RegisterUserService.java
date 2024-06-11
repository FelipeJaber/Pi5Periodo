package com.pi.Services.User.RegisterUserService;

import com.pi.Models.UserModel;
import com.pi.Records.User.RegisterUserRecord;
import com.pi.Repositories.UserRepository;
import com.pi.Services.JWT.JWTServices;
import com.pi.Services.JWT.iJWTServices;
import com.pi.Services.Validations.Cpf.CpfValidationService;
import com.pi.Services.Validations.Cpf.iCpfValidationService;
import com.pi.Services.Validations.PhoneNumber.PhoneNumberValidationService;
import com.pi.Services.Validations.PhoneNumber.iPhoneNumberValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService implements iRegisterUserService{

    UserRepository userRepository;
    iJWTServices jwtService;
    iCpfValidationService cpfValidationService;
    iPhoneNumberValidationService phoneValidationService;

    @Autowired
    public RegisterUserService(UserRepository userRepository, JWTServices jwtService, CpfValidationService cpfValidationService, PhoneNumberValidationService phoneValidationService) {
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
