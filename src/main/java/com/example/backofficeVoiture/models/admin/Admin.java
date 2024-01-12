package com.example.backofficeVoiture.models.admin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String userName;

    String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin(Integer id, String userName ,String password) {
        this.setId(id);
        this.setPassword(password);
        this.setUserName(userName);
    }

    public Admin() {
    }

    public Admin(String userName, String password) {
        setUserName(userName);
        setPassword(password);
    }

}
