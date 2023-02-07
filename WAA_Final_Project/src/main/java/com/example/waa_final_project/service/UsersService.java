package com.example.waa_final_project.service;

import com.example.waa_final_project.Dto.UsersDto;
import com.example.waa_final_project.Entity.Users;

import java.util.List;

public interface UsersService {
    public List<UsersDto>  findAllUsers();
    public UsersDto    findById(long id);
    public void addUser(Users user);
    public void update(long id, Users users);
    public void deleteUser(long id);
}
