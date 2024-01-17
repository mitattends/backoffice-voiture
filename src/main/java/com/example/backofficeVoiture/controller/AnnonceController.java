package com.example.backofficeVoiture.controller;

import com.example.backofficeVoiture.form.AnnonceForm;
import com.example.backofficeVoiture.service.AnnonceService;
import com.example.backofficeVoiture.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "localhost:8100")
@RestController
@RequestMapping("/annonce")
public class AnnonceController {

    @Autowired
    AnnonceService annonceService;
    @GetMapping
    public ApiResponse getData(){
        return annonceService.annonceFormData();
    }
    @PostMapping
    public ApiResponse sendData(@RequestBody AnnonceForm annonceForm){
        return annonceService.insererAnnonce(annonceForm);
    }
}
