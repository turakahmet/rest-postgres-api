package com.postgrerest.dto;


import com.postgrerest.entity.Customer;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDto {
    private Long id;
    private String orderName;
    private BigDecimal amount;

    public OrderDto(String orderName, BigDecimal amount) {
        this.orderName=orderName;
        this.amount=amount;
    }
}
