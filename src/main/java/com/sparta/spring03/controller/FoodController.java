package com.sparta.spring03.controller;

import com.sparta.spring03.dto.FoodRequestDto;
import com.sparta.spring03.dto.FoodResponseDto;
import com.sparta.spring03.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {
    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService){
        this.foodService = foodService;
    }

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registe(@PathVariable Long restaurantId, @RequestBody List<FoodRequestDto> requestDto){
        foodService.addFoodList(restaurantId, requestDto);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<FoodResponseDto> getFoods(@PathVariable Long restaurantId) {
        return foodService.getFoodList(restaurantId);
    }
}
