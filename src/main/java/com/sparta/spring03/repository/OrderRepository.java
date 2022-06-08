package com.sparta.spring03.repository;

import com.sparta.spring03.model.OrderFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderFood, Long> {
}
