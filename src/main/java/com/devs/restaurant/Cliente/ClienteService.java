package com.devs.restaurant.Cliente;

import com.devs.restaurant.Pedido.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final PedidoRepository pedidoRepository;

    public ClienteService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

}
