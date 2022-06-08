package com.sparta.spring03.dto;

import com.sparta.spring03.model.Food;
import com.sparta.spring03.model.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FoodsResponseDto {
    private String name;
    private int quantity;
    private int price;

    public FoodsResponseDto(Food food, int quantity) {
        this.name = food.getName();
        this.quantity = quantity;
        this.price = food.getPrice()* quantity;
    }

    public FoodsResponseDto(OrderDetail orderDetail) {
        this.name = orderDetail.getName();
        this.quantity = orderDetail.getQuantity();
        this.price = orderDetail.getPrice();
    }
}
