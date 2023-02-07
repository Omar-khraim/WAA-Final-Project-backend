package com.example.waa_final_project.Controller;

import com.example.waa_final_project.Dto.UsersDto;
import com.example.waa_final_project.Entity.Users;
import com.example.waa_final_project.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    UsersService    usersService;

    @GetMapping
    public List<UsersDto> getAllUsers(){
        return usersService.findAllUsers();
    }

    @GetMapping("/{id}")
    public UsersDto getUser(@PathVariable long id){
        return usersService.findById(id);
    }

    @PostMapping
    public void addUser(@RequestBody Users user){
        usersService.addUser(user);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody Users user){
        usersService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){
        usersService.deleteUser(id);
    }


}
