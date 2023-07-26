package com.postgrerest.controller;


import com.postgrerest.dto.CustomerDto;
import com.postgrerest.entity.Customer;
import com.postgrerest.entity.hataMessages.hataMesaj.HataMesaj;
import com.postgrerest.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<String> kaydet(@RequestBody Customer customer) {
        try {
            customerService.save(customer);
            return new ResponseEntity<>("Müşteri başarıyla kaydedildi.", HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(HataMesaj.KAYIT_EKLERKEN_HATA.getEtiket()+e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> tumunuListele() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @RequestMapping(value = "byId", method = RequestMethod.GET)
    public CustomerDto findCustomerById(@RequestParam("id") long id) {
        try {
            CustomerDto customerDto=new CustomerDto(customerService.getCustomerById(id));
            return new ResponseEntity<>(customerDto, HttpStatus.OK).getBody();
        } catch (Exception e) {
            return new ResponseEntity<CustomerDto>(HttpStatus.NOT_FOUND).getBody();
        }
    }
}
