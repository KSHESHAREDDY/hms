package com.javatraining.demo.respository;

import com.javatraining.demo.domain.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepositroy extends CrudRepository<Room, Long> {
}
