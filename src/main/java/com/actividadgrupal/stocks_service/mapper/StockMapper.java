package com.actividadgrupal.stocks_service.mapper;

import com.actividadgrupal.stocks_service.dto.StockDto;
import com.actividadgrupal.stocks_service.entity.Stock;

public class StockMapper {

    public static StockDto mapToStockDto(Stock stock) {

        return new StockDto(
                stock.getId(),
                stock.getProductId(),
                stock.getQuantity());
    }

    public static Stock mapToStock(StockDto stockDto) {
        return new Stock(
                stockDto.getId(),
                stockDto.getProductId(),
                stockDto.getQuantity());
    }

}
