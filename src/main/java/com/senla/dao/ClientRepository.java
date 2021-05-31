package com.senla.dao;

import com.senla.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query(value = "SELECT * FROM mydbtest.client WHERE apps_number = :number", nativeQuery = true)
    Client getByNumber(@Param("number") Integer number);
}
