package com.actividadgrupal.stocks_service.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class StockResponse {
    private Long id;
    private Long productId;
    private Integer quantity;
    private boolean isInStock;
}
