package com.sparta.spring03.service;

import com.sparta.spring03.dto.FoodRequestDto;
import com.sparta.spring03.dto.FoodResponseDto;
import com.sparta.spring03.model.Food;
import com.sparta.spring03.model.Restaurant;
import com.sparta.spring03.repository.FoodRepository;
import com.sparta.spring03.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository, RestaurantRepository restaurantRepository) {
        this.foodRepository = foodRepository;
        this.restaurantRepository = restaurantRepository;
    }
    @Transactional
    public void addFoodList(Long restaurantId, List<FoodRequestDto> requestDto) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(()->new NullPointerException("음식점이 존재하지않습니다."));
        for (FoodRequestDto foodRequestDto : requestDto) {
            if (foodRepository.existsFoodByNameAndRestaurant(foodRequestDto.getName(), restaurant)) {
                throw new IllegalArgumentException("음식명 중복입니다.");
            }

            Food food = new Food(restaurant, foodRequestDto);
            foodRepository.save(food);
        }

    }

    public List<FoodResponseDto> getFoodList(Long restaurantId) {
        List<Food> foodList = foodRepository.findAllByRestaurantId(restaurantId);
        List<FoodResponseDto> foodResponseDtoList = new ArrayList<>();
        for(Food food : foodList){
            foodResponseDtoList.add(new FoodResponseDto(food));
        }
        return foodResponseDtoList;
    }
}
