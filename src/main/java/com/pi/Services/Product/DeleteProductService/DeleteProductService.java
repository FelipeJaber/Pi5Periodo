package com.pi.Services.Product.DeleteProductService;

import com.pi.Enums.UserRolesEnum;
import com.pi.Models.ProductModel;
import com.pi.Models.UserModel;
import com.pi.Records.Product.DeleteProductRecord;
import com.pi.Repositories.ProductRepository;
import com.pi.Repositories.UserRepository;
import com.pi.Services.JWT.JWTServices;
import com.pi.Services.JWT.iJWTServices;
import com.pi.Session.UserSessionSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class DeleteProductService implements iDeleteProductService{

    ProductRepository productRepository;
    UserRepository userRepository;
    iJWTServices jwtService;

    @Autowired
    public DeleteProductService(ProductRepository productRepository, UserRepository userRepository, JWTServices jwtService) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public void deleteProduct(DeleteProductRecord deleteProductRecord, UUID productID) throws Exception {
        authenticateUser(deleteProductRecord);
        verifyIfSolicitantIsAdmin();
        removeProductFromDB(productID);
    }

    private void authenticateUser(DeleteProductRecord deleteProductRecord) throws Exception {
        UserSessionSingleton session = UserSessionSingleton.getInstance();
        session.authenticateByToken(deleteProductRecord.token());
    }

    private void verifyIfSolicitantIsAdmin() throws Exception {
        UserModel userModel = UserSessionSingleton.getInstance().getUserModel();
        if(!Objects.equals(userModel.getRole().toLowerCase(), UserRolesEnum.ADMIN.name().toLowerCase())) throw new Exception("USUARIO NÃO É ADMNISTRADOR");
    }

    private void removeProductFromDB(UUID productID) throws Exception {

        Optional<ProductModel> productModelDB = productRepository.findById(productID);

        if(productModelDB.isEmpty()){
            throw new Exception("ID DE PRODUTO NÃO COINCIDE COM NENHUM ID REGISTRADO");
        }

        productRepository.delete(productModelDB.get());
    }


}
