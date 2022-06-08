package com.sparta.spring03.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class OrderFood {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @OneToMany
    @Column(nullable = false)
    private List<OrderDetail> foods;

    @Column(nullable = false)
    private int totalPrice;

    public OrderFood(Restaurant restaurant, List<OrderDetail> foods, int totalPrice){
        this.restaurant = restaurant;
        this.foods = foods;
        this.totalPrice = totalPrice;
    }
}
