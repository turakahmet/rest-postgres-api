package com.postgrerest.dto;

import com.postgrerest.entity.Customer;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
public class CustomerDto {

    private String customerName;
    private String customerSurname;
    private String city;
    private Customer.Cinsiyet type;
    private List<OrderDto> orderList=new ArrayList<>();

    public CustomerDto(Customer customer) {
        this.customerName=customer.getCustomerName();
        this.customerSurname=customer.getCustomerSurname();
        this.city=customer.getCity();
        this.type=customer.getType();
        customer.getOrderList().forEach(item->{
            this.orderList.add(new OrderDto(item.getId(),item.getOrderName(),item.getAmount()));
        });

    }

    public CustomerDto(Optional<Customer> customerById) {
        if(customerById.isPresent()){
            this.customerName=customerById.get().getCustomerName();
            this.customerSurname=customerById.get().getCustomerSurname();
            this.city=customerById.get().getCity();
            this.type=customerById.get().getType();
            this.orderList= customerById.get().getOrderList().stream().map(OrderDto::new).collect(Collectors.toList());
        }
    }
}
