package com.example.backofficeVoiture.marque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/marque")
public class MarqueController {

    @Autowired
    MarqueService marqueService;

    @PostMapping
    public void insert(@RequestBody Marque marque){
        System.out.println(marque.getNom());
        this.marqueService.insert(marque);
    }
}
