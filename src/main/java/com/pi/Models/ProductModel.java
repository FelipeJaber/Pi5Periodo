package com.pi.Models;

import com.pi.Records.Product.AddProductRecord;
import com.pi.Records.Product.UpdateProductRecord;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_products")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id", nullable = false, unique = true, updatable = false)
    UUID productId;
    @Column(name = "product_name", nullable = false)
    String name;
    @Column(name = "product_description", nullable = false)
    String description;
    @Column(name = "product_price", nullable = false)
    float price;
    @Column(name = "product_section", nullable = false)
    String section;
    @Column(name = "product_stock", nullable = false)
    int stock;

    public ProductModel(UUID productId, String name, String description, float price, String section, int quantity) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.section = section;
        this.stock = quantity;
    }

    public ProductModel(AddProductRecord addProductRecord){
        this.description = addProductRecord.description();
        this.name = addProductRecord.name();
        this.price = addProductRecord.price();
        this.stock = addProductRecord.stock();
        this.section = addProductRecord.section();
    }

    public ProductModel(UpdateProductRecord updateProductRecord, UUID productId){
        this.description = updateProductRecord.description();
        this.name = updateProductRecord.name();
        this.price = updateProductRecord.price();
        this.stock = updateProductRecord.stock();
        this.section = updateProductRecord.section();
        this.productId = productId;
    }

    public ProductModel(UUID productId){
        this.productId = productId;
    }

    public ProductModel() {
    }

}
