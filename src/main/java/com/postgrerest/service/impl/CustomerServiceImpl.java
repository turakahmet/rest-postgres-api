package com.postgrerest.service.impl;

import com.postgrerest.dto.CustomerDto;
import com.postgrerest.entity.Customer;
import com.postgrerest.repository.CustomerRepository;
import com.postgrerest.repository.OrderRepository;
import com.postgrerest.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

//    @Autowired
//    private BaseDao baseDao;

    @Override
    @Transactional
    public void save(Customer customer) {
        Customer savedCustomer =customerRepository.save(customer);
        savedCustomer.getOrderList().forEach(order -> {
            order.setCustomer(savedCustomer);
            orderRepository.save(order);
        });
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerDto> getAll() {
        List<Customer> customerList=customerRepository.findAll();
        List<CustomerDto> customerDtoList = new ArrayList<>();
        customerList.forEach(ct -> {
            customerDtoList.add(new CustomerDto(ct));
        });
        return customerDtoList;
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }
}
