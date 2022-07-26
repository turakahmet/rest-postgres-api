package com.postgrerest.service;

import com.postgrerest.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto save(CustomerDto customerDto);

    void delete(Long id);

    List<CustomerDto> getAll();
}
