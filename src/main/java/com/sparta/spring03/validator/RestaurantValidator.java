package com.sparta.spring03.validator;

import com.sparta.spring03.dto.RestaurantRequestDto;
import org.springframework.stereotype.Component;

@Component
public class RestaurantValidator {

    public static void validateRestaurantInput(RestaurantRequestDto requestDto) {
//        if (userId == null || userId <= 0) {
//            throw new IllegalArgumentException("회원 Id 가 유효하지 않습니다.");
//        }

        if (requestDto.getMinOrderPrice() <1000 || requestDto.getMinOrderPrice()>100000) {
            throw new IllegalArgumentException("입력가능한 최소주문가격의 범위는 1,000~100,000원 입니다.");
        }

        if (requestDto.getMinOrderPrice()%100 !=0) {
            throw new IllegalArgumentException("최소주문가격의 입력은 100원 단위로만 가능합니다.");
        }
        if (requestDto.getDeliveryFee() <0 || requestDto.getDeliveryFee()>10000) {
            throw new IllegalArgumentException("입력가능한 기본배달비의 범위는 0~10,000원 입니다.");
        }

        if (requestDto.getDeliveryFee()%500 !=0) {
            throw new IllegalArgumentException("기본배달비의 입력은 500원 단위로만 가능합니다.");
        }

    }
}
