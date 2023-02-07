package com.example.waa_final_project.Dto.LogIn;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenRequestDTO {

    private String accessToken;
    private String refreshToken;
}
