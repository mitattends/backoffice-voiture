package com.example.backofficeVoiture.controller;

import com.example.backofficeVoiture.form.AnnonceForm;
import com.example.backofficeVoiture.model.AnnonceUpdateDTO;
import com.example.backofficeVoiture.service.AnnonceService;
import com.example.backofficeVoiture.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping("/annonce")
@CrossOrigin("*")
public class AnnonceController {

    @Autowired
    AnnonceService annonceService;
    @GetMapping
    @CrossOrigin(origins = "*")
    public ApiResponse getData(@RequestHeader("Authorization") String token) throws AccessDeniedException {
        return annonceService.annonceFormData(token);
    }
    @GetMapping("/{idUser}")
    @CrossOrigin(origins = "*")
    public ApiResponse getDataByUser(@PathVariable String idUser,@RequestHeader("Authorization") String token){
        System.out.println("annonce par utilisateur");
        return annonceService.obetnirAnnonces(token);
    }
    @PostMapping
    @CrossOrigin(origins = "*")
    public ApiResponse sendData(@RequestBody AnnonceForm annonceForm,
                                @RequestHeader("Authorization") String token){
        System.out.println("Ampiditra");
        return annonceService.insererAnnonce(annonceForm, token);
    }
    @PutMapping
    @CrossOrigin(origins = "*")
    public ApiResponse updateAnnonce(@RequestBody AnnonceUpdateDTO annonceUpdateDTO,
                                     @RequestHeader("Authorization") String token){
        return annonceService.updateAnnonce(annonceUpdateDTO, token);
    }
    @DeleteMapping("/{idAnnonce}")
    @CrossOrigin(origins = "*")
    public void deleteAnnonce(
            @PathVariable(name = "idAnnonce") final String idAnnonce, @RequestHeader("Authorization") String token) throws AccessDeniedException {
        annonceService.delete(idAnnonce, token);
    }
    @GetMapping("/admin/{etat}")
    @CrossOrigin(origins = "*")
    public ApiResponse getPendingAnnonce(@PathVariable String etat, @RequestHeader("Authorization") String token){
        return annonceService.getPendingAnnonce(etat, token);
    }

    @PutMapping("/admin")
    @CrossOrigin(origins = "*")
    public ApiResponse valider(@RequestBody AnnonceUpdateDTO annonceUpdateDTO,
                                     @RequestHeader("Authorization") String token){
        return annonceService.validerAnnonce(annonceUpdateDTO, token);
    }

}
