package com.sparta.spring03.validator;

import com.sparta.spring03.dto.FoodRequestDto;

public class OrderValidator {
    public static void validateQuantityInput(int quantity) {
        if (quantity<1 || quantity>100) {
            throw new IllegalArgumentException("한 음식의 주문가능 범위는 1~100개입니다.");
        }
    }

    public static void validateTotalInput(int total, int min) {
        if(total<min){
            throw new IllegalArgumentException("총금액이 최소 주문가격보다 낮습니다.");
        }
    }
}
