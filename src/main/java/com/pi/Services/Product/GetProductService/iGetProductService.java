package com.pi.Services.Product.GetProductService;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface iGetProductService {

    public String getProduct(UUID idProduct) throws Exception;
}
