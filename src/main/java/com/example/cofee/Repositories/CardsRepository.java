package com.example.cofee.Repositories;

import com.example.cofee.Entities.SQL.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий карт
 */
@Repository
public interface CardsRepository extends JpaRepository<Cards,Long> {
}
