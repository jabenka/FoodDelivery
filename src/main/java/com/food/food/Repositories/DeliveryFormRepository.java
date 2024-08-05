package com.food.food.Repositories;

import com.food.food.Models.DeliveryForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryFormRepository extends JpaRepository<DeliveryForm, Long> {
    @Override
    Optional<DeliveryForm> findById(Long aLong);
}