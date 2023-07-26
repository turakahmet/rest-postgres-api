package com.postgrerest.dto;


import com.postgrerest.entity.Order;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDto {
    private String orderName;
    private BigDecimal amount;

    public OrderDto(Long id, String orderName, BigDecimal amount) {
        this.orderName=orderName;
        this.amount=amount;
    }

    public OrderDto(List<Order> orderList) {
        for (Order values :orderList){
            this.orderName=values.getOrderName();
            this.amount=values.getAmount();
        }
    }


    public OrderDto(Order order) {
        this.orderName=order.getOrderName();
        this.amount=order.getAmount();
    }
}
