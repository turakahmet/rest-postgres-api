package com.postgrerest.repository;

import com.postgrerest.dto.CustomerDto;
import com.postgrerest.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
