package com.senla.dao;

import com.senla.entity.Room;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {
    List<Room> findByNumber(Integer number);

    @Modifying
    @Query("UPDATE room SET number =: 1 WHERE id =: 1")
    boolean updateByNumber(@Param("id") Integer id, @Param("number") Integer number);
}
