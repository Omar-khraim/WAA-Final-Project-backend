package com.example.waa_final_project.Controller;

import com.example.waa_final_project.Dto.UsersDto;
import com.example.waa_final_project.Entity.Offer;
import com.example.waa_final_project.Entity.Users;
import com.example.waa_final_project.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    UsersService usersService;

    @GetMapping
    public List<UsersDto> getAllUsers(){
        return usersService.findAllUsers();
    }

    @GetMapping("/{id}")
    public UsersDto getUser(@PathVariable long id){
        return usersService.findById(id);
    }

    @PostMapping
    public void addUser(@RequestBody UsersDto user){
        usersService.addUser(user);
    }

    @PutMapping
    public void update(@RequestBody UsersDto user){
        usersService.update(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){
        usersService.deleteUser(id);
    }





}
