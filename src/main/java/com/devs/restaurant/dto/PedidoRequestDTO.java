package com.devs.restaurant.dto;

import lombok.Data;

import java.util.List;

@Data
public class PedidoRequestDTO {
    private Long clienteId;
    private List<ItemRequestDTO> itens;
}
