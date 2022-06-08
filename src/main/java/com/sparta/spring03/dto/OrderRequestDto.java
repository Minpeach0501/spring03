package com.sparta.spring03.dto;

import lombok.Getter;

import java.util.List;


@Getter
public class OrderRequestDto {
    private Long restaurantId;
    private List<OrderDetailRequestDto> foods;

}
