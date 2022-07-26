package com.postgrerest.service.impl;

import com.postgrerest.dto.CustomerDto;
import com.postgrerest.dto.OrderDto;
import com.postgrerest.entity.Customer;
import com.postgrerest.entity.Order;
import com.postgrerest.repository.CustomerRepository;
import com.postgrerest.repository.OrderRepository;
import com.postgrerest.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl  implements CustomerService {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public CustomerDto save(CustomerDto customerDto) {

        Customer customer=new Customer();
        customer.setCustomerName(customerDto.getCustomerName());
        customer.setCustomerSurname(customerDto.getCustomerSurname());
        customer.setCity(customerDto.getCity());
        customer.setType(customerDto.getType());
        final Customer customerDb= customerRepository.save(customer);
        List<Order> orderList=new ArrayList<>();

        customerDto.getOrderList().forEach(item->{
            Order order=new Order();
            order.setCustomer(customerDb);
            order.setAmount(item.getAmount());
            order.setOrderName(item.getOrderName());
            orderRepository.save(order);
        });
        customerDto.setId(customerDb.getId());
        return customerDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<CustomerDto> getAll() {
        List<Customer> customerList=customerRepository.findAll();
        List<CustomerDto> customerDtoList = new ArrayList<>();
            customerList.forEach(ct->{
            CustomerDto customerDto=new CustomerDto();
            customerDto.setId(ct.getId());
            customerDto.setCustomerName(ct.getCustomerName());
            customerDto.setCustomerSurname(ct.getCustomerSurname());
            customerDto.setCity(ct.getCity());
            List<OrderDto> orderDtoList=new ArrayList<>();
            ct.getOrderList().forEach(item->{
                orderDtoList.add(new OrderDto(item.getOrderName(),item.getAmount()));
            });
            customerDto.setOrderList(orderDtoList);
                customerDtoList.add(customerDto);
        });
        return customerDtoList;
    }
}
