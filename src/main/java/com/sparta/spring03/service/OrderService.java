package com.sparta.spring03.service;

import com.sparta.spring03.dto.FoodsResponseDto;
import com.sparta.spring03.dto.OrderDetailRequestDto;
import com.sparta.spring03.dto.OrderRequestDto;
import com.sparta.spring03.dto.OrderResponseDto;
import com.sparta.spring03.model.Food;
import com.sparta.spring03.model.OrderDetail;
import com.sparta.spring03.model.OrderFood;
import com.sparta.spring03.model.Restaurant;
import com.sparta.spring03.repository.FoodRepository;
import com.sparta.spring03.repository.OrderDetailRepository;
import com.sparta.spring03.repository.OrderRepository;
import com.sparta.spring03.repository.RestaurantRepository;
import com.sparta.spring03.validator.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestaurantRepository restaurantRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final FoodRepository foodRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, RestaurantRepository restaurantRepository, FoodRepository foodRepository, OrderDetailRepository orderDetailRepository) {
        this.orderRepository = orderRepository;
        this.restaurantRepository = restaurantRepository;
        this.foodRepository = foodRepository;
        this.orderDetailRepository = orderDetailRepository;
    }


    public OrderResponseDto createOrder(OrderRequestDto requestDto) {
        Restaurant restaurant = restaurantRepository.findById(requestDto.getRestaurantId())
                .orElseThrow(()->new NullPointerException("해당음식점이 없습니다."));

        List<FoodsResponseDto> foods = new ArrayList<>();
        List<OrderDetail> orderList = new ArrayList<>();

        int totalPrice = 0;
        for(OrderDetailRequestDto orderDetailRequestDto : requestDto.getFoods()) {
            Food food = foodRepository.findById(orderDetailRequestDto.getId())
                    .orElseThrow(()-> new NullPointerException("주문한 음식이 존재하지 않습니다."));

            int quantity = orderDetailRequestDto.getQuantity();
            OrderValidator.validateQuantityInput(quantity);

            OrderDetail orderDetail = new OrderDetail(food, quantity);
            orderList.add(orderDetail);
            orderDetailRepository.save(orderDetail);

            FoodsResponseDto order = new FoodsResponseDto(food, quantity);
            totalPrice += order.getPrice();
            foods.add(order);
        }
        OrderValidator.validateTotalInput(totalPrice, restaurant.getMinOrderPrice());
        totalPrice += restaurant.getDeliveryFee();
        OrderFood orderFood = new OrderFood(restaurant, orderList, totalPrice);
        orderRepository.save(orderFood);

        return new OrderResponseDto(restaurant.getName(), foods, restaurant.getDeliveryFee(), totalPrice);
    }

    public List<OrderResponseDto> gerOrders() {
        List<OrderResponseDto> order = new ArrayList<>();

        for(OrderFood orderFood : orderRepository.findAll()){

            List<FoodsResponseDto> foods = new ArrayList<>();
            for(OrderDetail orderDetail : orderFood.getFoods()){
                foods.add(new FoodsResponseDto(orderDetail));
            }

            order.add(new OrderResponseDto(orderFood.getRestaurant().getName(), foods, orderFood.getRestaurant().getDeliveryFee(), orderFood.getTotalPrice()));
        }
        return order;
    }
}
