package com.example.backofficeVoiture.models.admin;

import java.util.HashMap;
import java.util.Map;

import com.example.backofficeVoiture.model.AdministrateurDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.backofficeVoiture.util.ApiResponse;
import com.example.backofficeVoiture.util.JwtUtil;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdministrateurController {
    @Autowired
    AdministrateurService administrateurService;

    @PostMapping("/login")
    public ApiResponse login(@RequestBody AdministrateurDTO administrateurDTO){
        return administrateurService.verify(administrateurDTO);
    }
    @PostMapping("/signin")
    public ApiResponse signin(@RequestBody AdministrateurDTO administrateurDTO){
        return administrateurService.insert(administrateurDTO);
    }

}
