package com.example.waa_final_project.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSignUpDto {


    private String name;
    private String email;
    private String username;
    private String password;
    private long roleId;

}
