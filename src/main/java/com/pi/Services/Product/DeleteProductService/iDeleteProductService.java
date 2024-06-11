package com.pi.Services.Product.DeleteProductService;

import com.pi.Records.Product.DeleteProductRecord;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface iDeleteProductService {

    void deleteProduct(DeleteProductRecord deleteProductRecord, UUID productID) throws Exception;
}
