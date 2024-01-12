package com.example.backofficeVoiture.models.admin;

import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Integer> {
    Admin findByUserName(String userName);
}
