package com.postgrerest.controller;


import com.postgrerest.dto.CustomerDto;
import com.postgrerest.entity.Customer;
import com.postgrerest.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> kaydet(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok(customerService.save(customerDto));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> tumunuListele() {
        return ResponseEntity.ok(customerService.getAll());
    }
}
