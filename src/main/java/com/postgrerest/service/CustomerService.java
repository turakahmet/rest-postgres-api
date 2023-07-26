package com.postgrerest.service;

import com.postgrerest.dto.CustomerDto;
import com.postgrerest.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {

    void save(Customer customer);

    void delete(Long id);

    List<CustomerDto> getAll();

    Optional<Customer> getCustomerById(Long id);
}
