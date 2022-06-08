package com.sparta.spring03.repository;

import com.sparta.spring03.model.Food;
import com.sparta.spring03.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findAllByRestaurantId(Long restaurantId);

    boolean existsFoodByNameAndRestaurant(String name, Restaurant restaurant);
}
