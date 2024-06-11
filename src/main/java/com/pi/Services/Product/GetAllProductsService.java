package com.pi.Services.Product;

import com.google.gson.Gson;
import com.pi.Models.ProductModel;
import com.pi.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetAllProductsService {

    ProductRepository productRepository;
    Gson gson;

    @Autowired
    public GetAllProductsService(ProductRepository productRepository, Gson gson) {
        this.productRepository = productRepository;
        this.gson = gson;
    }

    public String getAllProducts(){
        List<ProductModel> productList = productRepository.findAll();
        return transformProductsInJson(productList);
    }

    private String transformProductsInJson(List<ProductModel> productList){
        return gson.toJson(productList);
    }
}
