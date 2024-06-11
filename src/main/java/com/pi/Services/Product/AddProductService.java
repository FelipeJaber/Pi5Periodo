package com.pi.Services.Product;

import com.pi.Enums.UserRolesEnum;
import com.pi.Models.ProductModel;
import com.pi.Models.UserModel;
import com.pi.Records.Product.AddProductRecord;
import com.pi.Records.User.GetUserRecord;
import com.pi.Repositories.ProductRepository;
import com.pi.Services.JWT.JWTService;
import com.pi.Session.UserSessionSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AddProductService {

    ProductRepository productRepository;
    JWTService jwtService;

    @Autowired
    public AddProductService(ProductRepository productRepository, JWTService jwtService) {
        this.productRepository = productRepository;
        this.jwtService = jwtService;
    }

    public void addProduct(AddProductRecord addProductRecord)throws Exception{
        authenticateUser(addProductRecord);
        verifyIfSolicitantIsAdmin();
        entryValidation(addProductRecord);
        saveProduct(addProductRecord);
    }

    private void saveProduct(AddProductRecord addProductRecord) throws Exception{
        ProductModel productModel = new ProductModel(addProductRecord);
        productRepository.save(productModel);
    }

    private void entryValidation(AddProductRecord addProductRecord)throws Exception{
        if(addProductRecord.price() < 0) throw new Exception("PREÇO INVALIDO");
        if(addProductRecord.stock() < 0) throw new Exception("ESTOQUE INVALIDO");
    }

    private void authenticateUser(AddProductRecord addProductRecord) throws Exception {
        UserSessionSingleton session = UserSessionSingleton.getInstance();
        session.authenticateByToken(addProductRecord.token());
    }

    private void verifyIfSolicitantIsAdmin() throws Exception {
        UserModel userModel = UserSessionSingleton.getInstance().getUserModel();
        if(!Objects.equals(userModel.getRole().toLowerCase(), UserRolesEnum.ADMIN.name().toLowerCase())) throw new Exception("USUARIO NÃO É ADMNISTRADOR");
    }


}
