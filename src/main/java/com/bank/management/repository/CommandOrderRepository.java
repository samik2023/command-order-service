package com.bank.management.repository;

import com.bank.management.entity.CommandOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandOrderRepository extends JpaRepository<CommandOrder, Long> {

}
