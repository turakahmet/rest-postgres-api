package com.postgrerest.dto;


import com.postgrerest.entity.Order;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDto {
    private Long id;
    private String orderName;
    private BigDecimal amount;

    public OrderDto(Long id, String orderName, BigDecimal amount) {
        this.id=id;
        this.orderName=orderName;
        this.amount=amount;
    }
}
