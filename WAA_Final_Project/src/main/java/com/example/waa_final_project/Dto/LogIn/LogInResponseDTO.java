package com.example.waa_final_project.Dto.LogIn;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogInResponseDTO {
    private String accessToken ;
    private String refreshToken;
    private String userName;
    private long userId;
    private long role;
}
