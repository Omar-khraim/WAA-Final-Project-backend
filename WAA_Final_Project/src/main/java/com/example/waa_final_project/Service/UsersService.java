package com.example.waa_final_project.Service;

import com.example.waa_final_project.Dto.UserSignUpDto;
import com.example.waa_final_project.Dto.UsersDto;
import com.example.waa_final_project.Entity.Offer;
import com.example.waa_final_project.Entity.Users;

import java.util.List;

public interface UsersService {
    public List<UsersDto>  findAllUsers();
    public UsersDto    findById(long id);
    public void addUser(UserSignUpDto user);
    public void update(UsersDto users);
    public void deleteUser(long id);
    Users findAllByEmail(String email);


}
