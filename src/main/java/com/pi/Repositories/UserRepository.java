package com.pi.Repositories;

import com.pi.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
    public Optional<UserModel> findByPhone(String phone);
    public Optional<UserModel> findByCpf(String cpf);
}
