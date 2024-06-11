package com.pi.Services.Validations.Cpf;

import org.springframework.stereotype.Service;

@Service
public interface iCpfValidationService {

    public boolean verifyIfCpfIsValid(String cpf) throws Exception;
    public String formatCpf(String cpf) throws Exception;
    public void verifyIfCPFAlreadyRegistered(String cpf) throws Exception;
}
