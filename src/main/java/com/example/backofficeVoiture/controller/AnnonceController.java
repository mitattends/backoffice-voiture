package com.example.backofficeVoiture.controller;

import com.example.backofficeVoiture.form.AnnonceForm;
import com.example.backofficeVoiture.model.AnnonceUpdateDTO;
import com.example.backofficeVoiture.service.AnnonceService;
import com.example.backofficeVoiture.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;

@CrossOrigin(origins = "localhost:8100")
@RestController
@RequestMapping("/annonce")
public class AnnonceController {

    @Autowired
    AnnonceService annonceService;
    @GetMapping
    public ApiResponse getData(@RequestHeader("Authorization") String token) throws AccessDeniedException {
        return annonceService.annonceFormData(token);
    }
    @GetMapping("/{idUser}")
    public ApiResponse getDataByUser(@PathVariable String idUser,@RequestHeader("Authorization") String token){
        System.out.println("annonce par utilisateur");
        return annonceService.obetnirAnnonces(token);
    }
    @PostMapping
    public ApiResponse sendData(@RequestBody AnnonceForm annonceForm,
                                @RequestHeader("Authorization") String token){
        return annonceService.insererAnnonce(annonceForm, token);
    }
    @PutMapping
    public ApiResponse updateAnnonce(@RequestBody AnnonceUpdateDTO annonceUpdateDTO,
                                     @RequestHeader("Authorization") String token){
        return annonceService.updateAnnonce(annonceUpdateDTO, token);
    }
    @DeleteMapping("/{idAnnonce}")
    public void deleteAnnonce(
            @PathVariable(name = "idAnnonce") final String idAnnonce, @RequestHeader("Authorization") String token) throws AccessDeniedException {
        annonceService.delete(idAnnonce, token);
    }
    @GetMapping("/admin/{etat}")
    public ApiResponse getPendingAnnonce(@PathVariable String etat){
        return annonceService.getPendingAnnonce(etat);
    }
}
