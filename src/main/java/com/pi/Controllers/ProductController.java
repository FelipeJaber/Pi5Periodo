package com.pi.Controllers;

import com.pi.Records.Product.AddProductRecord;
import com.pi.Records.Product.DeleteProductRecord;
import com.pi.Records.Product.UpdateProductRecord;
import com.pi.Services.Product.AddProductService.AddProductService;
import com.pi.Services.Product.AddProductService.iAddProductService;
import com.pi.Services.Product.DeleteProductService.DeleteProductService;
import com.pi.Services.Product.DeleteProductService.iDeleteProductService;
import com.pi.Services.Product.GetAllProductsService.GetAllProductsService;
import com.pi.Services.Product.GetAllProductsService.iGetAllProductsService;
import com.pi.Services.Product.GetProductService.GetProductService;
import com.pi.Services.Product.GetProductService.iGetProductService;
import com.pi.Services.Product.GetSectionProductsService.GetSectionProductsService;
import com.pi.Services.Product.GetSectionProductsService.iGetSectionProductsService;
import com.pi.Services.Product.UpdateProductService.UpdateProductService;
import com.pi.Services.Product.UpdateProductService.iUpdateProductService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Transactional
@RestController
@RequestMapping("/products")
public class ProductController {

    private final iAddProductService addProductService;
    private final iDeleteProductService deleteProductService;
    private final iGetAllProductsService getAllProductsService;
    private final iGetProductService getProductService;
    private final iGetSectionProductsService getSectionProductsService;
    private final iUpdateProductService updateProductService;

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
