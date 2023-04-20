package com.postgrerest.dto;

import com.postgrerest.entity.Customer;
import com.postgrerest.entity.Order;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerDto {

    private Long id;
    private String customerName;
    private String customerSurname;
    private String city;
    private Customer.Cinsiyet type;
    private List<OrderDto> orderList=new ArrayList<>();

    public CustomerDto(Customer customer) {
        this.id=customer.getId();
        this.customerName=customer.getCustomerName();
        this.customerSurname=customer.getCustomerSurname();
        this.city=customer.getCity();
        this.type=customer.getType();
        customer.getOrderList().forEach(item->{
            this.orderList.add(new OrderDto(item.getId(),item.getOrderName(),item.getAmount()));
        });

    }
}
