package com.senla.dao;

import com.senla.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query (value = "SELECT * FROM room WHERE number = :number", nativeQuery = true)
    Room getByNumber(@Param("number") Integer number);

    @Modifying
    @Query(value = "UPDATE Room r SET r.free_status = :status WHERE r.number = :number", nativeQuery = true)
    @Transactional
    void updateFreeStatus(@Param("status") boolean free_status, @Param("number") Integer number);
}
