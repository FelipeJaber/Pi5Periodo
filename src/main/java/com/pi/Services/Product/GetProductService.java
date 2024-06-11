package com.pi.Services.Product;

import com.google.gson.Gson;
import com.pi.Models.ProductModel;
import com.pi.Models.UserModel;
import com.pi.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GetProductService {


    ProductRepository productRepository;
    Gson gson;

    @Autowired
    public GetProductService(ProductRepository productRepository, Gson gson) {
        this.productRepository = productRepository;
        this.gson = gson;
    }

    public String getProduct(UUID idProduct) throws Exception{
        return transformProductsInJson(findProduct(idProduct));
    }

    private ProductModel findProduct(UUID idProduct) throws Exception{
        Optional<ProductModel> productModel = productRepository.findById(idProduct);
        if(productModel.isEmpty()) throw new Exception("PRODUTO NÃO ENCONTRADO");
        return productModel.get();
    }

    private String transformProductsInJson(ProductModel productModel){
        return gson.toJson(productModel);
    }
}
