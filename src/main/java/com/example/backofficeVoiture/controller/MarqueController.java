package com.example.backofficeVoiture.controller;

import com.example.backofficeVoiture.domain.Marque;
import com.example.backofficeVoiture.service.MarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/marque")
public class MarqueController {
    @Autowired
    MarqueService marqueService;
    @GetMapping
    public List<Marque> getAll(){
        return marqueService.findAll();
    }
}
