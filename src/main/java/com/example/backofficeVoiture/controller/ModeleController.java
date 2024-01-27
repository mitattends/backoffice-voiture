package com.example.backofficeVoiture.controller;

import com.example.backofficeVoiture.domain.Modele;
import com.example.backofficeVoiture.model.ModeleDTO;
import com.example.backofficeVoiture.repos.ModeleRepository;
import com.example.backofficeVoiture.service.ModelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modele")
@CrossOrigin("*")
public class ModeleController {

    private final ModelService modeleService;
    public ModeleController(ModelService modeleService) {
        this.modeleService = modeleService;
    }

    @GetMapping
    public ResponseEntity<List<ModeleDTO>> getAllModeles() {
        return ResponseEntity.ok(modeleService.findAll());
    }

    @GetMapping("/{idModele}")
    public ResponseEntity<ModeleDTO> getModele(
            @PathVariable(name = "idModele") final String idModele) throws Exception {
        return ResponseEntity.ok(modeleService.get(idModele));
    }

    @PostMapping
    public ResponseEntity<String> createModele(@RequestBody @Valid final ModeleDTO modeleDTO) throws Exception {
        final String createdIdModele = modeleService.create(modeleDTO);
        return new ResponseEntity<>(createdIdModele, HttpStatus.CREATED);
    }

    @PutMapping("/{idModele}")
    public ResponseEntity<String> updateModele(
            @PathVariable(name = "idModele") final String idModele,
            @RequestBody @Valid final ModeleDTO modeleDTO) throws Exception {
        modeleService.update(idModele, modeleDTO);
        return ResponseEntity.ok(idModele);
    }

    @DeleteMapping("/{idModele}")
    public ResponseEntity<Void> deleteModele(
            @PathVariable(name = "idModele") final String idModele) {
        modeleService.delete(idModele);
        return ResponseEntity.noContent().build();
    }

}
