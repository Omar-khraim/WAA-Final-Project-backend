package com.example.waa_final_project.Service;

import com.example.waa_final_project.Entity.Role;

import java.util.List;

public interface RoleService {
    public List<Role>  findAllRoles();
    public Role   findById(long id);
    public void addRole(Role role);
    public void update(long id, Role role);
    public void deleteRole(long id);
}
