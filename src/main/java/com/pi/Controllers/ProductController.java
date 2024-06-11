package com.pi.Controllers;

import com.pi.Records.Product.AddProductRecord;
import com.pi.Records.Product.DeleteProductRecord;
import com.pi.Records.Product.UpdateProductRecord;
import com.pi.Services.Product.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Transactional
@RestController
@RequestMapping("/products")
public class ProductController {

    private final AddProductService addProductService;
    private final DeleteProductService deleteProductService;
    private final GetAllProductsService getAllProductsService;
    private final GetProductService getProductService;
    private final GetSectionProductsService getSectionProductsService;
    private final UpdateProductService updateProductService;

    public ProductController(
            AddProductService addProductService,
            DeleteProductService deleteProductService,
            GetAllProductsService getAllProductsService,
            GetProductService getProductService,
            GetSectionProductsService getSectionProductsService,
            UpdateProductService updateProductService
    ) {
        this.addProductService = addProductService;
        this.deleteProductService = deleteProductService;
        this.getAllProductsService = getAllProductsService;
        this.getProductService = getProductService;
        this.getSectionProductsService = getSectionProductsService;
        this.updateProductService = updateProductService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getProduct(@NotBlank @NotNull @PathVariable("id") String productId) {
        try{
            return ResponseEntity.ok(getProductService.getProduct(UUID.fromString(productId)));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/section/{section}")
    public ResponseEntity<String> getSectionProducts(@NotBlank @NotNull @PathVariable("section") String section) {
        return ResponseEntity.ok(getSectionProductsService.getSectionProducts(section));
    }

    @GetMapping("/all")
    public ResponseEntity<String> getAllProducts() {
        return ResponseEntity.ok(getAllProductsService.getAllProducts());
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@Valid @RequestBody AddProductRecord addProductRecord){
        try {
            addProductService.addProduct(addProductRecord);
            return ResponseEntity.ok("PRODUTO ADICIONADO COM SUCESSO");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable("id") String productId, @Valid @RequestBody UpdateProductRecord updateProductRecord) {
        try{
            updateProductService.updateProduct(updateProductRecord, UUID.fromString(productId));
            return ResponseEntity.ok("PRODUTO ALTERADO COM SUCESSO");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") String productId, @Valid @RequestBody DeleteProductRecord deleteProductRecord) {
        try{
            deleteProductService.deleteProduct(deleteProductRecord, UUID.fromString(productId));
            return ResponseEntity.ok("PRODUTO DELETADO COM SUCESSO");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
