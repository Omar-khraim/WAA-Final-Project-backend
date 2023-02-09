package com.example.waa_final_project.Dto;

import com.example.waa_final_project.Entity.Property;
import com.example.waa_final_project.Entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {

    private String name;
    private String email;
    private String username;
    @JsonIgnore
    private String password;

    private Role role;
    private List<Property> properties;
}
