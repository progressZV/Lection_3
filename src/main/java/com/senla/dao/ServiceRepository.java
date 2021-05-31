package com.senla.dao;

import com.senla.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    @Query(value = "SELECT * FROM mydbtest.service WHERE Name = :name", nativeQuery = true)
    Service getByName(@Param("name") String name);
}
