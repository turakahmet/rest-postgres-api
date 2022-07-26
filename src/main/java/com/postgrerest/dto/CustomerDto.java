package com.postgrerest.dto;

import com.postgrerest.entity.Customer;
import com.postgrerest.entity.Order;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class CustomerDto {

    private Long id;
    private String customerName;
    private String customerSurname;
    private String city;
    private Customer.Cinsiyet type;
    private List<OrderDto> orderList;
}
