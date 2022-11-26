package com.r2g.mscustomer.service;

import com.r2g.mscustomer.entity.Customer;
import com.r2g.mscustomer.entity.Region;

import java.util.List;

public interface CustomerService {
    public List<Customer> findCustomerAll();
    public Customer createCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public Customer deleteCustomer(Customer customer);
    public List<Customer> findCustomerByRegion(Region region);
    public Customer getCustomer(Long id);

}
