package com.pi.Services.Validations.PhoneNumber;

import org.springframework.stereotype.Service;

@Service
public interface iPhoneNumberValidationService {

    boolean verifyIfPhoneIsValid(String phone) throws Exception;
    String formatPhone(String phone)throws Exception;
    void verifyIfPhoneAlreadyRegistered(String phone) throws Exception;
}
