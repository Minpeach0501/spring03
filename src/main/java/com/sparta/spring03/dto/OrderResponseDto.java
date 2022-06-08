package com.sparta.spring03.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@Getter
public class OrderResponseDto {

    private String restaurantName;

    private List<FoodsResponseDto> foods;

    private int deliveryFee;

    private int totalPrice;

    public OrderResponseDto(String restaurantName, List<FoodsResponseDto> foods, int deliveryFee, int totalPrice){
        this.restaurantName = restaurantName;
        this.foods = foods;
        this.deliveryFee = deliveryFee;
        this.totalPrice = totalPrice;
    }
}
