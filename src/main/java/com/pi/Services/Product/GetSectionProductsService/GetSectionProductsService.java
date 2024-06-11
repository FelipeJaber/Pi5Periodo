package com.pi.Services.Product.GetSectionProductsService;

import com.google.gson.Gson;
import com.pi.Models.ProductModel;
import com.pi.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetSectionProductsService implements iGetSectionProductsService{

    ProductRepository productRepository;
    Gson gson;

    @Autowired
    public GetSectionProductsService(ProductRepository productRepository, Gson gson) {
        this.productRepository = productRepository;
        this.gson = gson;
    }

    public String getSectionProducts(String section){
        return transformProductsInJson(findProducts(section));
    }

    private List<ProductModel> findProducts(String section){
        return productRepository.findAllBySection(section);
    }

    private String transformProductsInJson(List<ProductModel> productList){
        return gson.toJson(productList);
    }

}
