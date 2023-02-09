package com.example.waa_final_project.Service.Impl;

import com.example.waa_final_project.Dto.UsersDto;
import com.example.waa_final_project.Entity.Users;
import com.example.waa_final_project.Reposetory.OfferRepo;
import com.example.waa_final_project.Reposetory.UsersRepo;
import com.example.waa_final_project.Service.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl  implements UsersService {

    private final OfferRepo offerRepo;
    private final   UsersRepo   usersRepo;
    private final ModelMapper mapper;

    public UsersServiceImpl(OfferRepo offerRepo, UsersRepo usersRepo, ModelMapper mapper) {
        this.offerRepo = offerRepo;
        this.usersRepo = usersRepo;
        this.mapper = mapper;
    }


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
    public void addUser(UsersDto user) {
        usersRepo.save(mapper.map(user , Users.class));
    }

    @Override
    public void update(UsersDto user) {
        usersRepo.save(mapper.map(user , Users.class));
    }

    @Override
    public void deleteUser(long id) {
        usersRepo.deleteById(id);
    }

    @Override
    public Users findAllByEmail(String email) {
        return usersRepo.findAllByEmail(email);
    }

}
