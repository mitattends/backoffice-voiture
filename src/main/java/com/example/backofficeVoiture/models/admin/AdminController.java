package com.example.backofficeVoiture.models.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.backofficeVoiture.util.ApiResponse;
import com.example.backofficeVoiture.util.JwtUtil;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {
    @Autowired
    AdminRepository adminRepository;

    JwtUtil jwtUtil = new JwtUtil();

    @PostMapping(path = "/save")
    public @ResponseBody ApiResponse addNewAdmin(
            @RequestParam String username,
            @RequestParam String password) {
        Admin admin = new Admin(username, password);
        adminRepository.save(admin);
        String token = jwtUtil.generate(admin);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("success");
        apiResponse.setData(Map.of("token", token));
        return apiResponse;
    }

    @GetMapping(path = "/all")
    public @ResponseBody ApiResponse getAllAdmin() {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("success");
        apiResponse.setData(Map.of("admins", adminRepository.findAll()));
        return apiResponse;
    }

    @PostMapping(path = "/login")
    public @ResponseBody ApiResponse login(
            String userName,
            String password) {
        Admin admin = adminRepository.findByUserName(userName);
        ApiResponse apiResponse = new ApiResponse();
        if (admin != null) {
            apiResponse.setMessage("utilisateur trouvé");
            apiResponse.setData(Map.of("admin", admin));
        }
        apiResponse.setMessage("utilisateur trouvé");
        return apiResponse;
    }

}
