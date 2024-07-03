package com.actividadgrupal.stocks_service.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StockRequest {
    private Long productId;
    private Integer quantity;
}
