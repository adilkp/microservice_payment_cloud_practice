package com.payments.repositories;

import com.payments.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Transaction, Long> {

    @Query(value = "select * from transaction where user_id=?1", nativeQuery = true)
    List<Transaction> findByUser_id(Long user_id);
}
