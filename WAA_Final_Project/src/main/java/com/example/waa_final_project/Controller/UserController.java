package com.example.waa_final_project.Controller;

import com.example.waa_final_project.Dto.AddPropertyDto;
import com.example.waa_final_project.Dto.LogIn.OfferDTO;
import com.example.waa_final_project.Dto.PropertyDto;
import com.example.waa_final_project.Dto.UserSignUpDto;
import com.example.waa_final_project.Dto.UsersDto;
import com.example.waa_final_project.Entity.Offer;
import com.example.waa_final_project.Service.OfferService;
import com.example.waa_final_project.Service.PropertyService;
import com.example.waa_final_project.Service.UsersService;
import com.example.waa_final_project.AOP.annotation.SendEmail;
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
    @Autowired
    PropertyService propertyService;

    @GetMapping
    public List<UsersDto> getAllUsers() {
        return usersService.findAllUsers();
    }

    @GetMapping("/{id}")
    public UsersDto getUser(@PathVariable long id) {
        return usersService.findById(id);
    }

    @PostMapping
    public void addUser(@RequestBody UserSignUpDto user) {
        usersService.addUser(user);
    }

    @PutMapping
    public void update(@RequestBody UsersDto user) {
        usersService.update(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        usersService.deleteUser(id);
    }


    @SendEmail
    @PostMapping("/{user_id}/properties/{prop_id}/offers")
    public String addUserPost(@PathVariable(name = "prop_id") long prop_id, @PathVariable(name = "user_id") long user_id, @RequestBody OfferDTO offer) {
        offerService.sendOffer(prop_id, user_id, offer);
        return "sent successfully";
    }

    @GetMapping("/{owner_id}/properties")
    public List<PropertyDto> findOwnerProperties(@PathVariable(name = "owner_id") long owner_id) {
        return propertyService.findAllByOwner_Id(owner_id);
    }

    @GetMapping("{customer_id}/CustomerOffers")
    public List<Offer> getAllCustomerOffers(@PathVariable long customer_id) {
        return offerService.findAllByUser_Id(customer_id);
    }

    @GetMapping("{owner_id}/OwnerOffers")
    public List<Offer> getOwnerOffers(@PathVariable long owner_id) {
        return offerService.findAllByProperty_Owner_Id(owner_id);
    }

    @GetMapping("/properties/{prop_id}/offers")
    public List<Offer> getOwnerPropertyOffers(@PathVariable(name = "prop_id") long prop_id) {
        return offerService.findOffersByProperty_Id(prop_id);
    }

    @PostMapping("{owner_id}/property")
    public void addProperty(@PathVariable long owner_id,@RequestBody AddPropertyDto property) {
        propertyService.addProperty(owner_id,property);
    }


}
