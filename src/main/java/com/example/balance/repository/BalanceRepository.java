/**
 * 
 */
package com.example.balance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.balance.dao.OutputDetailRecord;

/**
 * 
 */
public interface BalanceRepository extends JpaRepository<OutputDetailRecord, Long> {

}
