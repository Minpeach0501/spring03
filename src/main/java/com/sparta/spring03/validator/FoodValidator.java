package com.sparta.spring03.validator;

import com.sparta.spring03.dto.FoodRequestDto;

public class FoodValidator {
    public static void validateFoodInput(FoodRequestDto foodRequestDto) {
        if (foodRequestDto.getPrice()<100 || foodRequestDto.getPrice()>1000000) {
            throw new IllegalArgumentException("음식가격의 범위는 100~1,000,000원 입니다.");
        }

        if (foodRequestDto.getPrice()%100 !=0) {
            throw new IllegalArgumentException("음식가격은 100원단위로 입력가능합니다.");
        }

    }
}
