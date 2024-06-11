package com.pi.Services.Validations.Cpf;

import org.springframework.stereotype.Service;

@Service
public interface iCpfValidationService {

    boolean verifyIfCpfIsValid(String cpf) throws Exception;
    String formatCpf(String cpf) throws Exception;
    void verifyIfCPFAlreadyRegistered(String cpf) throws Exception;
}
