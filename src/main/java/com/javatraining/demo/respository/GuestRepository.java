package com.javatraining.demo.respository;

import com.javatraining.demo.domain.Guest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {
//    @Query(value = "select g from Guest g where g.email = :emailId")
//    Guest getGuestByEmailId(@Param(value = "emailId") String emailId);

    Guest findGuestByEmail(String email);

    Guest findGuestByEmailAndPhoneNumber(String email, Long phoneNumber);
}
