package com.r2g.mscustomer.repository;

import com.r2g.mscustomer.entity.Customer;
import com.r2g.mscustomer.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    public Customer findByNumberID(String numbeID);
    public List<Customer> findByLastName(String lastName);
    public List<Customer> findByRegion(Region region);
}
