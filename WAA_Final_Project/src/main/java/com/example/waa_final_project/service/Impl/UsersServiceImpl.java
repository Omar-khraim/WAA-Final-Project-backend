package com.example.waa_final_project.service.Impl;

import com.example.waa_final_project.Dto.UsersDto;
import com.example.waa_final_project.Entity.Users;
import com.example.waa_final_project.Reposetory.UsersRepo;
import com.example.waa_final_project.service.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl  implements UsersService {
    @Autowired
    UsersRepo   usersRepo;
    @Autowired
    ModelMapper mapper;
    @Override
    public List<UsersDto> findAllUsers() {
        return usersRepo.findAll().stream()
                .map(u -> mapper.map(u, UsersDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UsersDto findById(long id) {
        return mapper.map(usersRepo.findById(id).orElse(null), UsersDto.class);
    }

    @Override
    public void addUser(Users user) {
        usersRepo.save(user);
    }

    @Override
    public void update(long id, Users user) {
        deleteUser(id);
        user.setId(id);
        addUser(user);
    }

    @Override
    public void deleteUser(long id) {
        usersRepo.deleteById(id);
    }
}
