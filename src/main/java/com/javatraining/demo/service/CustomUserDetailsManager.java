package com.javatraining.demo.service;

import com.javatraining.demo.domain.Customer;
import com.javatraining.demo.respository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

public class CustomUserDetailsManager implements UserDetailsManager {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void createUser(UserDetails user) {

    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findCustomerByUserName(username);
        if (customer == null) {
            throw new UsernameNotFoundException("Username {0} not found");
        } else {
            return User.withUsername(customer.getUserName()).password(customer.getPassword()).build();
        }
    }
}
