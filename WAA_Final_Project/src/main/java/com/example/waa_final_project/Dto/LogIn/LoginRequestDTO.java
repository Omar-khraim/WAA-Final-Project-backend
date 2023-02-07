package com.example.waa_final_project.Dto.LogIn;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequestDTO {

    private String email;
    private String password ;
}
