package com.actividadgrupal.stocks_service.repository;

import com.actividadgrupal.stocks_service.entity.Stock;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StockRepository extends CrudRepository<Stock, Long> {
    List<Stock> findByProductIdIn(List<Long> productId);
    Optional<Stock> findByProductId(Long productId);
}
