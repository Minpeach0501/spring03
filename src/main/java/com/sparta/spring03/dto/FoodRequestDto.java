package com.sparta.spring03.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FoodRequestDto {
    private String name;
    private int price;
}
