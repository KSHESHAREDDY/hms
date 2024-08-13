package com.javatraining.demo.respository;

import com.javatraining.demo.common.ReservationStatus;
import com.javatraining.demo.domain.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    @Query(value = "update Reservation r set r.reservationStatus =:reservationStatus where r.id =:rId")
    void updateReservationStatusById(@Param(value = "rId") Long rId, @Param(value = "reservationStatus") ReservationStatus reservationStatus);
}
