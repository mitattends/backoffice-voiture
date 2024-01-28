package com.example.backofficeVoiture.controller;

import com.example.backofficeVoiture.domain.Marque;
import com.example.backofficeVoiture.model.MarqueDTO;
import com.example.backofficeVoiture.service.MarqueService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
    public ResponseEntity<String> createMarque(@RequestBody @Valid final MarqueDTO marqueDTO, @RequestHeader("Authorization") String token) throws Exception {
        final String createdIdMarque = marqueService.create(marqueDTO, token);
        return new ResponseEntity<>(createdIdMarque, HttpStatus.CREATED);
    }

    @PutMapping("/{idMarque}")
    public ResponseEntity<String> updateMarque(
            @PathVariable(name = "idMarque") final String idMarque,
            @RequestBody @Valid final MarqueDTO marqueDTO) throws Exception {
        marqueService.update(idMarque, marqueDTO);
        return ResponseEntity.ok(idMarque);
    }

    @DeleteMapping("/{idMarque}")
    public ResponseEntity<Void> deleteMarque(
            @PathVariable(name = "idMarque") final String idMarque) {
        marqueService.delete(idMarque);
        return ResponseEntity.noContent().build();
    }

}
