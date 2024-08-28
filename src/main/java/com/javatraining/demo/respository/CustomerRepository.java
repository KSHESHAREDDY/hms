package com.javatraining.demo.respository;

import com.javatraining.demo.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    public Customer findCustomerByUserName(String username);
}
