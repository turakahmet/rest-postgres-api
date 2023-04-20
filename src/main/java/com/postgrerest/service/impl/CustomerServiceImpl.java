package com.postgrerest.service.impl;

import com.postgrerest.dao.BaseDao;
import com.postgrerest.dto.CustomerDto;
import com.postgrerest.entity.Customer;
import com.postgrerest.hibernate.HibernateUtil;
import com.postgrerest.repository.CustomerRepository;
import com.postgrerest.repository.OrderRepository;
import com.postgrerest.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    @Autowired
    private BaseDao baseDao;

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
    public Customer getCustomerById(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        EntityManager entityManager =sessionFactory.createEntityManager();
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(
                "select new Map(c.customerName as musteri_ad,c.city as musteri_sehri) from Customer c where c.id =:id ");
        query.setParameter("id", id);
        Customer customer = (Customer) query.uniqueResult();
        transaction.commit();
        return customer;
    }
}
