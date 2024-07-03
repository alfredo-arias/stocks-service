package com.actividadgrupal.stocks_service.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StockAlreadyExistsException  extends RuntimeException {

    private String mensaje;

    public StockAlreadyExistsException(String mensaje) {
        this.mensaje = mensaje;
    }
}
