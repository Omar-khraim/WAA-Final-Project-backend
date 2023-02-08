package com.example.waa_final_project.Controller;

import com.example.waa_final_project.Dto.LogIn.LogInResponseDTO;
import com.example.waa_final_project.Dto.LogIn.LoginRequestDTO;
import com.example.waa_final_project.Dto.LogIn.RefreshTokenRequestDTO;
import com.example.waa_final_project.Service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authenticate")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        var loginResponse = authService.login(loginRequest);
        return new ResponseEntity<LogInResponseDTO>(
                loginResponse, HttpStatus.OK);
    }

    @PostMapping("/refreshToken")
    public LogInResponseDTO refreshToken(@RequestBody RefreshTokenRequestDTO refreshTokenRequest){
        return authService.refreshToken(refreshTokenRequest);
    }
}
