package com.sparta.spring03.service;


import com.sparta.spring03.dto.RestaurantRequestDto;
import com.sparta.spring03.model.Restaurant;
import com.sparta.spring03.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant regist(RestaurantRequestDto restaurantRequestDto) {
        Restaurant restaurant = new Restaurant(restaurantRequestDto);
        restaurantRepository.save(restaurant);
        return restaurant;
    }

    public List<Restaurant> getlist() {
        return restaurantRepository.findAll();
    }
}
