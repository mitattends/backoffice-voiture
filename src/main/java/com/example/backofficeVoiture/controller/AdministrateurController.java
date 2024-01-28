package com.example.backofficeVoiture.controller;

import com.example.backofficeVoiture.model.AdministrateurDTO;
import com.example.backofficeVoiture.service.AdministrateurService;
import com.example.backofficeVoiture.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdministrateurController {
    @Autowired
    AdministrateurService administrateurService;

    @PostMapping("/login")
    public ApiResponse login(@RequestBody AdministrateurDTO administrateurDTO){
        return administrateurService.verify(administrateurDTO);
    }
    @PostMapping("/signin")
    public ApiResponse signin(@RequestBody AdministrateurDTO administrateurDTO, @RequestHeader("Authorization") String token){
        return administrateurService.insert(administrateurDTO, token);
    }

}