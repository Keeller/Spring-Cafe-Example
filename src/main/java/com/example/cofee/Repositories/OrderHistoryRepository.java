package com.example.cofee.Repositories;

import com.example.cofee.Entities.SQL.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий историии заказов
 */
@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory,Long> {
}
