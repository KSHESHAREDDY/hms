package com.javatraining.demo.controller;

import com.javatraining.demo.domain.Customer;
import com.javatraining.demo.respository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping(path = "/add")
    public String addCustomer(@RequestBody Customer customer) {
        Customer isCustomerExists = customerRepository.findCustomerByUserName(customer.getUserName());
        if (isCustomerExists == null) {
            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
            customerRepository.save(customer);
        } else {
            return customer.getUserName() + "User Already Exists";
        }
        return customer.getUserName() + "User Add successfully";
    }
}
