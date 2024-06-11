package com.pi.Services.Product;

import com.pi.Enums.UserRolesEnum;
import com.pi.Models.ProductModel;
import com.pi.Models.UserModel;
import com.pi.Records.Product.DeleteProductRecord;
import com.pi.Repositories.ProductRepository;
import com.pi.Repositories.UserRepository;
import com.pi.Services.JWT.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class DeleteProductService {

    ProductRepository productRepository;
    UserRepository userRepository;
    JWTService jwtService;

    @Autowired
    public DeleteProductService(ProductRepository productRepository, UserRepository userRepository, JWTService jwtService) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public void deleteProduct(DeleteProductRecord deleteProductRecord, UUID productID) throws Exception {
        verifyIfSolicitantIsAdmin(deleteProductRecord);
        removeProductFromDB(deleteProductRecord, UUID.randomUUID());
    }

    private void verifyIfSolicitantIsAdmin(DeleteProductRecord deleteProductRecord) throws Exception {
        UserModel userModel = jwtService.getUserFromToken(deleteProductRecord.token());
        if(!Objects.equals(userModel.getRole().toLowerCase(), UserRolesEnum.ADMIN.name().toLowerCase())) throw new Exception("USUARIO NÃO É ADMNISTRADOR");
    }

    private void removeProductFromDB(DeleteProductRecord deleteProductRecord, UUID productID) throws Exception {

        Optional<ProductModel> productModelDB = productRepository.findById(productID);

        if(productModelDB.isEmpty()){
            throw new Exception("ID DE PRODUTO NÃO COINCIDE COM NENHUM ID REGISTRADO");
        }

        productRepository.delete(productModelDB.get());
    }


}
