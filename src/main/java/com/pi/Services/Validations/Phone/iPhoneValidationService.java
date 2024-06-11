package com.pi.Services.Validations.Phone;

import org.springframework.stereotype.Service;

@Service
public interface iPhoneValidationService {

    public boolean verifyIfPhoneIsValid(String phone) throws Exception;
    public String formatPhone(String phone)throws Exception;
    public void verifyIfPhoneAlreadyRegistered(String phone) throws Exception;
}
