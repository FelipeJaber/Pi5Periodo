package com.pi.Services.Product.UpdateProductService;

import com.pi.Enums.UserRolesEnum;
import com.pi.Models.ProductModel;
import com.pi.Models.UserModel;
import com.pi.Records.Product.UpdateProductRecord;
import com.pi.Repositories.ProductRepository;
import com.pi.Session.UserSessionSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class UpdateProductService implements iUpdateProductService{

    ProductRepository productRepository;

    @Autowired
    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void updateProduct(UpdateProductRecord updateProductRecord, UUID idProduto) throws Exception {
        authenticateUser(updateProductRecord);
        verifyIfSolicitantIsAdmin();

    }

    private void changeProduct(UpdateProductRecord updateProductRecord, UUID idProduto) throws Exception{
        Optional<ProductModel> dbProductModel = productRepository.findById(idProduto);
        if(dbProductModel.isEmpty()) throw new Exception("PRODUTO COM O ID "+idProduto+" NÃO LOCALIZADO");
        ProductModel newProduct = dbProductModel.get();
        newProduct.setName(updateProductRecord.name());
        newProduct.setPrice(updateProductRecord.price());
        newProduct.setQuantity(updateProductRecord.stock());
        newProduct.setDescription(updateProductRecord.description());
        newProduct.setSection(updateProductRecord.section());
        productRepository.save(newProduct);
    }


    private void authenticateUser(UpdateProductRecord updateProductRecord) throws Exception {
        UserSessionSingleton session = UserSessionSingleton.getInstance();
        session.authenticateByToken(updateProductRecord.token());
    }

    private void verifyIfSolicitantIsAdmin() throws Exception {
        UserModel userModel = UserSessionSingleton.getInstance().getUserModel();
        if(!Objects.equals(userModel.getRole().toLowerCase(), UserRolesEnum.ADMIN.name().toLowerCase())) throw new Exception("USUARIO NÃO É ADMNISTRADOR");
    }

}
