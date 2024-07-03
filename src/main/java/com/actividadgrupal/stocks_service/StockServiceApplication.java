package com.actividadgrupal.stocks_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockServiceApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner loadData(StockRepository stockRepository) {
//		return args -> {
//			Stock stock = new Stock();
//			stock.setProductId(1L);
//			stock.setQuantity(100);
//
//			Stock stock1 = new Stock();
//			stock1.setProductId(2L);
//			stock1.setQuantity(0);
//
//			Stock stock2 = new Stock();
//			stock2.setProductId(3L);
//			stock2.setQuantity(10);
//
//			Stock stock3 = new Stock();
//			stock3.setProductId(3L);
//			stock3.setQuantity(0);
//
//			stockRepository.save(stock);
//			stockRepository.save(stock1);
//			stockRepository.save(stock2);
//			stockRepository.save(stock3);
//
//		};
//	}
}
