package com.pi.Services.Product.UpdateProductService;

import com.pi.Records.Product.UpdateProductRecord;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface iUpdateProductService {

    void updateProduct(UpdateProductRecord updateProductRecord, UUID idProduto) throws Exception;
}
