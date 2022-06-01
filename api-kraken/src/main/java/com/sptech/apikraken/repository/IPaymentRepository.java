package com.sptech.apikraken.repository;

import com.sptech.apikraken.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentRepository extends JpaRepository<Payment, Integer> {
}
