package com.postgrerest.service;

import com.postgrerest.dto.CustomerDto;
import com.postgrerest.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    void save(Customer customer);

    void delete(Long id);

    List<CustomerDto> getAll();

    Customer getCustomerById(Long id);
}
