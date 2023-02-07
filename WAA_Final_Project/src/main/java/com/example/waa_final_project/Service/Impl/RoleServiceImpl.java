package com.example.waa_final_project.Service.Impl;

import com.example.waa_final_project.Entity.Role;
import com.example.waa_final_project.Reposetory.RoleRepo;
import com.example.waa_final_project.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepo    roleRepo;
    @Override
    public List<Role> findAllRoles() {
        return roleRepo.findAll();
    }

    @Override
    public Role findById(long id) {
        return roleRepo.findById(id).orElse(null);
    }

    @Override
    public void addRole(Role role) {
        roleRepo.save(role);
    }

    @Override
    public void update(long id, Role role) {
        deleteRole(id);
        role.setId(id);
        roleRepo.save(role);
    }

    @Override
    public void deleteRole(long id) {
        roleRepo.deleteById(id);
    }
}
