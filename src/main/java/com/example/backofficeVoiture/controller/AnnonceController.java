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
    @GetMapping("/all")
    public ApiResponse getDataByUser(@RequestHeader("Authorization") String token){
        return annonceService.obetnirAnnonces(token);
    }
    @PostMapping
    public ApiResponse sendData(@RequestBody AnnonceForm annonceForm,
                                @RequestHeader("Authorization") String token){
        return annonceService.insererAnnonce(annonceForm, token);
    }
    @PutMapping
    public ApiResponse updateAnnonce(@RequestHeader("Authorization") String token,
                                     @RequestParam String idAnnonce,
                                     @RequestParam String etat){
        return annonceService.updateAnnonce(idAnnonce, etat, token);
    }
}
