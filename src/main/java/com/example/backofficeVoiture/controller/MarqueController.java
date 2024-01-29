package com.example.backofficeVoiture.controller;

import com.example.backofficeVoiture.domain.Marque;
import com.example.backofficeVoiture.model.AdministrateurDTO;
import com.example.backofficeVoiture.model.MarqueDTO;
import com.example.backofficeVoiture.service.AdministrateurService;
import com.example.backofficeVoiture.service.MarqueService;
import com.example.backofficeVoiture.util.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marque")
public class MarqueController {

    private final MarqueService marqueService;

    public MarqueController(MarqueService marqueService) {
        this.marqueService = marqueService;
    }

    @GetMapping
    public ResponseEntity<List<Marque>> getAllMarques() {
        return ResponseEntity.ok(marqueService.findAll());
    }

    @GetMapping("/{idMarque}")
    public ResponseEntity<MarqueDTO> getMarque(
            @PathVariable(name = "idMarque") final String idMarque) throws Exception {
        return ResponseEntity.ok(marqueService.get(idMarque));
    }

    @PostMapping
    public ApiResponse createMarque(@RequestBody @Valid final MarqueDTO marqueDTO, @RequestHeader("Authorization") String token) throws Exception {
        return marqueService.create(marqueDTO, token);
    }

    @PutMapping("/{idMarque}")
    public ApiResponse updateMarque(
            @PathVariable(name = "idMarque") final String idMarque,
            @RequestBody @Valid final MarqueDTO marqueDTO, @RequestHeader("Authorization") String token) throws Exception {
        return marqueService.update(idMarque, marqueDTO, token);
    }

    @DeleteMapping("/{idMarque}")
    public ApiResponse deleteMarque(
            @PathVariable(name = "idMarque") final String idMarque, @RequestHeader("Authorization") String token) {
        return marqueService.delete(idMarque, token);
    }


}
