package com.example.backofficeVoiture.controller;

import com.example.backofficeVoiture.model.AxeDetailsDTO;
import com.example.backofficeVoiture.service.AxeDetailsService;
import com.example.backofficeVoiture.util.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/axe")
@CrossOrigin("*")
public class AxeDetailsController {
    private final AxeDetailsService axeDetailsService;

    public AxeDetailsController(AxeDetailsService axeDetailsService) {
        this.axeDetailsService = axeDetailsService;
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    public ApiResponse getAllAxeDetailss() {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.addData("axes", axeDetailsService.findAll());
        return apiResponse;
    }

    @GetMapping("/{idAxe}")
    @CrossOrigin(origins = "*")
    public ApiResponse getAxeDetails(
            @PathVariable(name = "idAxe") final String idAxe) throws Exception {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.addData("axe", axeDetailsService.get(idAxe));
        return apiResponse;
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> createAxeDetails(
            @RequestBody AxeDetailsDTO axeDetailsDTO) {
        String createdIdAxe = axeDetailsService.create(axeDetailsDTO);
        return new ResponseEntity<>(createdIdAxe, HttpStatus.CREATED);
    }

    @PutMapping("/{idAxe}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> updateAxeDetails(@PathVariable(name = "idAxe") final String idAxe,
                                                   @RequestBody @Valid final AxeDetailsDTO axeDetailsDTO) throws Exception {
        axeDetailsService.update(idAxe, axeDetailsDTO);
        return ResponseEntity.ok(idAxe);
    }

    @DeleteMapping("/{idAxe}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Void> deleteAxeDetails(@PathVariable(name = "idAxe") final String idAxe) {
        axeDetailsService.delete(idAxe);
        return ResponseEntity.noContent().build();
    }
}
