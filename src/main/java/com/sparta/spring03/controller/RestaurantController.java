package com.sparta.spring03.controller;

import com.sparta.spring03.dto.RestaurantRequestDto;
import com.sparta.spring03.model.Restaurant;
import com.sparta.spring03.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurant(){
        return restaurantService.getlist();
    }

    @PostMapping("/restaurant/register")
    public Restaurant createRestaurant(@RequestBody RestaurantRequestDto restaurantRequestDto){
        return restaurantService.regist(restaurantRequestDto);

    }
}
