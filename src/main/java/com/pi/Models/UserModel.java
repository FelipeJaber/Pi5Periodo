package com.pi.Models;

import com.pi.Enums.UserRolesEnum;
import com.pi.Records.User.RegisterUserRecord;
import com.pi.Records.User.UpdateUserRecord;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.UUID;

@Entity
@Table(name = "tb_user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", updatable = false, unique = true, nullable = false)
    UUID userID;
    @Column(name = "user_name", nullable = false)
    String name;
    @Column(name = "user_cpf", nullable = false, unique = true, updatable = false)
    String cpf;
    @Column(name = "user_phone", nullable = false, unique = true)
    String phone;
    @Column(name = "user_role", nullable = false)
    String role;
    @Column(name = "user_password", nullable = false)
    String passWord;

    public UserModel(UUID userID, String name, String cpf, String phone, String role, String passWord) {
        this.userID = userID;
        this.name = name;
        this.cpf = cpf;
        this.phone = phone;
        this.role = role;
        this.passWord = passWord;
    }

    public UserModel() {
    }

    public UserModel(RegisterUserRecord registerUserRecord) throws Exception{
        this.name = registerUserRecord.name();
        this.phone = registerUserRecord.phone();
        if(Arrays.stream(UserRolesEnum.values()).noneMatch(e -> e.name().equalsIgnoreCase(registerUserRecord.role()))) throw new Exception("ROLE INVALIDA");
        this.role = registerUserRecord.role();
        this.passWord = registerUserRecord.passWord();
        this.cpf = registerUserRecord.cpf();
    }

    public UserModel(UpdateUserRecord updateUserRecord) {
        this.name = updateUserRecord.nome();
        this.phone = updateUserRecord.phone();
        this.passWord = updateUserRecord.passWord();
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
