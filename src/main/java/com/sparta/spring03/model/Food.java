package com.sparta.spring03.model;

import com.sparta.spring03.dto.FoodRequestDto;
import com.sparta.spring03.validator.FoodValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Food {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    Restaurant restaurant;

    public Food(Restaurant restaurant, FoodRequestDto requestDto){

        FoodValidator.validateFoodInput(requestDto);
        this.restaurant = restaurant;
        this.name = requestDto.getName();
        this.price = requestDto.getPrice();
    }
}
