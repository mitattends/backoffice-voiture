package com.example.backofficeVoiture.controller;

import com.example.backofficeVoiture.domain.Modele;
import com.example.backofficeVoiture.repos.ModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/modele")
public class ModeleController {
    @Autowired
    ModeleRepository modeleRepository;
    @GetMapping
    public List<Modele> getAll(){
        return modeleRepository.findAll();
    }
}
