package com.example.cofee.Repositories;

import com.example.cofee.Entities.SQL.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиториц товаров
 */
@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
}
