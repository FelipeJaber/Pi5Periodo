package com.pi.Services.Product.AddProductService;

import com.pi.Records.Product.AddProductRecord;
import org.springframework.stereotype.Service;

@Service
public interface iAddProductService {

    void addProduct(AddProductRecord addProductRecord)throws Exception;
}
