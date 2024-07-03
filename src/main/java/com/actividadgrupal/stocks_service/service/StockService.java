package com.actividadgrupal.stocks_service.service;

import com.actividadgrupal.stocks_service.dto.StockDto;
import com.actividadgrupal.stocks_service.exception.StockAlreadyExistsException;
import com.actividadgrupal.stocks_service.mapper.StockMapper;
import com.actividadgrupal.stocks_service.dto.StockRequest;
import com.actividadgrupal.stocks_service.entity.Stock;
import com.actividadgrupal.stocks_service.repository.StockRepository;
import com.actividadgrupal.stocks_service.dto.StockResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class StockService {
    private final StockRepository stockRepository;

    @Transactional(readOnly = true)
    public List<StockResponse> isInStock(List<Long> productId) {
        List<StockResponse> stockResponses = stockRepository.findByProductIdIn(productId)
                .stream()
                .map(stock ->
                        StockResponse.builder()
                                .productId(stock.getProductId())
                                .isInStock(stock.getQuantity() > 0)
                                .build()
                )
                .toList();

        log.info("Received inventory check request for productId: {}", productId);

        return stockResponses;
    }

    public StockDto createStock(StockDto stockDto) {
        Optional<Stock> optionalStock = stockRepository.findByProductId(stockDto.getProductId());

//        if (optionalStock.isPresent()) {
//            throw new StockAlreadyExistsException("Stock already exists");
//        }

        log.info("StockDto: {}", stockDto.toString());

        Stock stock = StockMapper.mapToStock(stockDto);
        Stock savedStock = stockRepository.save(stock);
        return StockMapper.mapToStockDto(savedStock);
    }
}
