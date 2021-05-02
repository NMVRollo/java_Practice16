package com.example.Practice16.controller;

import com.example.Practice16.models.Dog;
import com.example.Practice16.models.User;
import com.example.Practice16.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {

    @Autowired
    private DogService dogService;

    @GetMapping(value = "/dog/{dogId}/user")
    public User getDogUser(@PathVariable("dogId") Long dogId){
        return dogService.getUserByDog(dogId);
    }

    @GetMapping
    public List<Dog> getAllDogs() {
        return dogService.getAllDogs();
    }

}
