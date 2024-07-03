package com.actividadgrupal.stocks_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StockDto {

    private Long id;

    @NotNull
    private Long productId;

    @NotNull
    private int quantity;

}
