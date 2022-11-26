package com.r2g.mscustomer.service;

import com.r2g.mscustomer.entity.Customer;
import com.r2g.mscustomer.entity.Region;
import com.r2g.mscustomer.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findCustomerAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        Customer customerBD = customerRepository.findByNumberID(customer.getNumberID());
        if (customerBD != null) {
            return customerBD;
        }
        customer.setState("CREATED");
        customerBD = customerRepository.save(customer);
        return customerBD;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer customerBD = getCustomer(customer.getId());
        if (customerBD == null) {
            return null;
        }
        customerBD.setFirstName(customer.getFirstName());
        customerBD.setLastName(customer.getLastName());
        customerBD.setEmail(customer.getEmail());
        customerBD.setPhotoUrl(customer.getPhotoUrl());
        return customerRepository.save(customerBD);
    }

    @Override
    public Customer deleteCustomer(Customer customer) {
        Customer customerBD = getCustomer(customer.getId());
        if (customerBD == null) {
            return null;
        }
        customer.setState("DELETED");
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findCustomerByRegion(Region region) {
        return customerRepository.findByRegion(region);
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

}
