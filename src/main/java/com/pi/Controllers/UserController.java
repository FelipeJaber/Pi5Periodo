package com.pi.Controllers;

import com.pi.Records.User.DeleteUserRecord;
import com.pi.Records.User.GetUserRecord;
import com.pi.Records.User.RegisterUserRecord;
import com.pi.Records.User.UpdateUserRecord;
import com.pi.Services.User.DeleteUserService;
import com.pi.Services.User.GetUserService;
import com.pi.Services.User.RegisterUserService;
import com.pi.Services.User.UpdateUserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Transactional
@RestController
@RequestMapping("/user")
public class UserController {

    DeleteUserService deleteUserService;
    GetUserService getUserService;
    RegisterUserService registerUserService;
    UpdateUserService updateUserService;

    @Autowired
    public UserController(DeleteUserService deleteUserService, GetUserService getUserService, RegisterUserService registerUserService, UpdateUserService updateUserService) {
        this.deleteUserService = deleteUserService;
        this.getUserService = getUserService;
        this.registerUserService = registerUserService;
        this.updateUserService = updateUserService;
    }

    @GetMapping("/getUserToken")
    public ResponseEntity<String> getUser(@Valid @RequestBody GetUserRecord getUserRecord) {

        try{
            String token = getUserService.getUser(getUserRecord);
            return ResponseEntity.ok(token);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody RegisterUserRecord registerUserRecord) {
        try{
            String token = registerUserService.RegisterUser(registerUserRecord);
            return ResponseEntity.ok(token);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@Valid @RequestBody UpdateUserRecord updateUserRecord) {
        try{
            updateUserService.updateUser(updateUserRecord);
            return ResponseEntity.ok("USUARIO ALTERADO COM SUCESSO");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@Valid @RequestBody DeleteUserRecord deleteUserRecord) {

        try{
            deleteUserService.deleteUser(deleteUserRecord);
            return ResponseEntity.ok("USUARIO DELETADO COM SUCESSO");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
