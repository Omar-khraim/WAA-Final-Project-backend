package com.example.waa_final_project.Service;


import com.example.waa_final_project.Dto.LogIn.LogInResponseDTO;
import com.example.waa_final_project.Dto.LogIn.LoginRequestDTO;
import com.example.waa_final_project.Dto.LogIn.RefreshTokenRequestDTO;

public interface AuthService {

    LogInResponseDTO login(LoginRequestDTO loginRequest);
    LogInResponseDTO refreshToken(RefreshTokenRequestDTO refreshTokenRequest);
}
