package com.example.waa_final_project.Controller;

import com.example.waa_final_project.Dto.UsersDto;
import com.example.waa_final_project.Entity.Offer;
import com.example.waa_final_project.Entity.Users;
import com.example.waa_final_project.Service.OfferService;
import com.example.waa_final_project.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("api/v1/users")
public class UserController {
    @Autowired
    UsersService usersService;
    @Autowired
    OfferService offerService;
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


    @PostMapping("/{user_id}/properties/{prop_id}/offers")
    public String addUserPost(@PathVariable(name = "prop_id") long prop_id,@PathVariable(name = "user_id") long user_id, @RequestBody Offer offer){
        offerService.sendOffer(prop_id,user_id,offer);
        return "sent successfully";
    }

    @GetMapping("{customer_id}/CustomerOffers")
    public List<Offer> getAllCustomerOffers(@PathVariable long customer_id){
        return offerService.findAllByUser_Id(customer_id);
    }
    @GetMapping("{owner_id}/OwnerOffers")
    public List<Offer> getOwnerOffers(@PathVariable long owner_id){
        return offerService.findAllByProperty_Owner_Id(owner_id);
    }


}
