package com.sparta.spring03.model;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int price;

    public OrderDetail(Food food, int quantity){
        this.name = food.getName();
        this.quantity = quantity;
        this.price = food.getPrice()* quantity;
    }
}
