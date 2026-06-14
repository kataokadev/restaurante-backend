package com.devs.restaurant.Pedido;

import com.devs.restaurant.dto.PedidoRequestDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/criar")
    public PedidoModel criarPedido(@RequestBody PedidoRequestDTO dto) {
        return pedidoService.criarPedido(dto);
    }

    @GetMapping("/listar")
    public List<PedidoModel> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    @GetMapping("/listar/{id}")
    public PedidoModel buscarPedidoPorId(@PathVariable Long id) {
        return pedidoService.buscarPedidoPorId(id);
    }

    @PatchMapping("/{id}/status")
    public PedidoModel atualizarStatus(@PathVariable Long id, @RequestParam PedidoStatus status) {
        return pedidoService.atualizarStatus(id, status);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarPedido(@PathVariable Long id) {
        pedidoService.deletarPedido(id);
    }
}