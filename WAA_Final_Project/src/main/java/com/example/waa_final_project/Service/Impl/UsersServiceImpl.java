package com.example.waa_final_project.Service.Impl;

import com.example.waa_final_project.Dto.UserSignUpDto;
import com.example.waa_final_project.Dto.UsersDto;
import com.example.waa_final_project.Entity.Projection.UserPropertiesPrice;
import com.example.waa_final_project.Entity.Users;
import com.example.waa_final_project.Entity.Projection.UserContactInfo;
import com.example.waa_final_project.Reposetory.OfferRepo;
import com.example.waa_final_project.Reposetory.RoleRepo;
import com.example.waa_final_project.Reposetory.UsersRepo;
import com.example.waa_final_project.Service.UsersService;
import com.example.waa_final_project.Util.Helper.ListMapper;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {

    private final OfferRepo offerRepo;
    private final RoleRepo roleRepo;
    private final UsersRepo usersRepo;
    private final ModelMapper mapper;
    private final ListMapper<Users, UsersDto> listMapper;

    private final PasswordEncoder passwordEncoder;

    public UsersServiceImpl(OfferRepo offerRepo, RoleRepo roleRepo, UsersRepo usersRepo, ModelMapper mapper, ListMapper<Users, UsersDto> listMapper, PasswordEncoder passwordEncoder) {
        this.offerRepo = offerRepo;
        this.roleRepo = roleRepo;
        this.usersRepo = usersRepo;
        this.mapper = mapper;
        this.listMapper = listMapper;
        this.passwordEncoder = passwordEncoder;
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
    @Transactional
    public void addUser(UserSignUpDto user) {
        Users newUser = new Users();
        newUser.setEmail(user.getEmail());
        newUser.setName(user.getName());
        newUser.setUsername(user.getUsername());
        newUser.setRole(roleRepo.findById(user.getRoleId()).get());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        usersRepo.save(newUser);
    }

    @Override
    public void update(UsersDto user) {
        usersRepo.save(mapper.map(user, Users.class));
    }

    @Override
    public void deleteUser(long id) {
        usersRepo.deleteById(id);
    }

    @Override
    public Users findAllByEmail(String email) {
        return usersRepo.findAllByEmail(email);
    }

    @Override
    public Users findUsersByProperties_id(long prop_id) {
        return usersRepo.findUsersByProperties_id(prop_id);
    }

    @Override
    public List<UsersDto> findUsersByProperty_Address_ZipCode(int zipCode) {
        return (List<UsersDto>) listMapper.mapList(usersRepo.findUsersByProperties_Address_ZipCode(zipCode), new UsersDto()) ;
    }

    @Override
    public List<UserContactInfo> getAllUsersContactInfo() {
        return usersRepo.findAllBy();
    }

    @Override
    public UserPropertiesPrice findUserPropertyPriceTotal(long userId) {
        return usersRepo.findUserPropertyPriceTotal(userId);
    }

}
