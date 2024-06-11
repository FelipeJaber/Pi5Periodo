package com.pi.Services.User.UpdateUserService;

import com.pi.Enums.UserRolesEnum;
import com.pi.Models.UserModel;
import com.pi.Records.User.UpdateUserRecord;
import com.pi.Repositories.UserRepository;
import com.pi.Services.JWT.JWTServices;
import com.pi.Services.JWT.iJWTServices;
import com.pi.Services.Validations.Cpf.CpfValidationService;
import com.pi.Services.Validations.Cpf.iCpfValidationService;
import com.pi.Services.Validations.Phone.PhoneValidationService;
import com.pi.Services.Validations.Phone.iPhoneValidationService;
import com.pi.Session.UserSessionSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserService implements iUpdateUserService{

    iCpfValidationService cpfValidationService;
    iPhoneValidationService phoneValidationService;
    iJWTServices jwtService;
    UserRepository userRepository;

    @Autowired
    public UpdateUserService(CpfValidationService cpfValidationService, PhoneValidationService phoneValidationService, JWTServices jwtService, UserRepository userRepository) {
        this.cpfValidationService = cpfValidationService;
        this.phoneValidationService = phoneValidationService;
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    public void updateUser(UpdateUserRecord updateUserRecord) throws Exception{
        authenticateUser(updateUserRecord);
        entryValidation(updateUserRecord);
        changeUser(updateUserRecord);
    }

    private void changeUser(UpdateUserRecord updateUserRecord){
        UserModel userModel = new UserModel(updateUserRecord);
        UserModel userModelAutenticado = UserSessionSingleton.getInstance().getUserModel();

        userModelAutenticado.setName(userModel.getName());
        userModelAutenticado.setPhone(userModel.getPhone());
        userModelAutenticado.setPhone(userModel.getPhone());
        if(userModelAutenticado.getRole().equals(UserRolesEnum.ADMIN.name())) userModelAutenticado.setRole(updateUserRecord.role());

        userRepository.save(userModelAutenticado);
    }

    private void authenticateUser(UpdateUserRecord updateUserRecord) throws Exception {
        UserSessionSingleton session = UserSessionSingleton.getInstance();
        session.authenticateByToken(updateUserRecord.token());
    }

    private void entryValidation(UpdateUserRecord updateUserRecord) throws Exception{
        String formattedPhone = phoneValidationService.formatPhone(updateUserRecord.phone());

        if(!phoneValidationService.verifyIfPhoneIsValid(formattedPhone)) throw new Exception("TELEFONE INVALIDO");
    }

}
