package com.actividadgrupal.stocks_service.controller;

import com.actividadgrupal.stocks_service.dto.StockDto;
import com.actividadgrupal.stocks_service.dto.StockRequest;
import com.actividadgrupal.stocks_service.dto.StockResponse;
import com.actividadgrupal.stocks_service.service.StockService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/stocks")
@RequiredArgsConstructor
@Slf4j
public class StockController {

    private final StockService stockService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<StockResponse>> isInStock(@RequestParam List<Long> productId){
        List<StockResponse> stockResponses = stockService.isInStock(productId);
        log.info("Received inventory check request for skuCode: {}", stockResponses);
        return new ResponseEntity<>(stockResponses, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<StockResponse> createStock(@RequestBody StockDto stockDto){

        log.info("====================================================================");
        log.info("StockDto: {}", stockDto);
        log.info("====================================================================");

        StockDto savedStockDto = stockService.createStock(stockDto);
        StockResponse stockResponse = new StockResponse();

        stockResponse.setId(savedStockDto.getId());
        stockResponse.setProductId(savedStockDto.getProductId());
        stockResponse.setQuantity(savedStockDto.getQuantity());

        return new ResponseEntity<>(stockResponse, HttpStatus.CREATED);
    }

}
