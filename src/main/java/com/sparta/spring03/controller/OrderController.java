package com.sparta.spring03.controller;

import com.sparta.spring03.dto.OrderRequestDto;
import com.sparta.spring03.dto.OrderResponseDto;
import com.sparta.spring03.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order/request")
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto requestDto) {
        return orderService.createOrder(requestDto);
    }

    @GetMapping("/orders")
    public List<OrderResponseDto> getOrders() {
        return orderService.gerOrders();
    }
}
