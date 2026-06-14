package com.devs.restaurant.Pedido;

import com.devs.restaurant.Cliente.ClienteModel;
import com.devs.restaurant.Cliente.ClienteRepository;
import com.devs.restaurant.ItemPedido.ItemPedidoModel;
import com.devs.restaurant.Produtos.ProdutosModel;
import com.devs.restaurant.Produtos.ProdutosRepository;
import com.devs.restaurant.dto.ItemRequestDTO;
import com.devs.restaurant.dto.PedidoRequestDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutosRepository produtosRepository;

    public PedidoService(PedidoRepository pedidoRepository,
                         ClienteRepository clienteRepository,
                         ProdutosRepository produtosRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtosRepository = produtosRepository;
    }

    @Transactional
    public PedidoModel criarPedido(PedidoRequestDTO dto) {
        ClienteModel cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado: " + dto.getClienteId()));

        PedidoModel pedido = new PedidoModel();
        pedido.setCliente(cliente);
        pedido.setStatus(PedidoStatus.REGISTRADO);
        pedido.setDataPedido(LocalDateTime.now());

        List<ItemPedidoModel> itens = new ArrayList<>();
        BigDecimal valorTotal = BigDecimal.ZERO;

        for (ItemRequestDTO itemDto : dto.getItens()) {
            ProdutosModel produto = produtosRepository.findById(itemDto.getProdutoId())
                    .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado: " + itemDto.getProdutoId()));

            ItemPedidoModel item = new ItemPedidoModel();
            item.setPedido(pedido);
            item.setProduto(produto);
            item.setQuantidade(itemDto.getQuantidade());
            item.setPrecoUnitario(produto.getPreco());

            itens.add(item);
            valorTotal = valorTotal.add(item.getSubtotal());
        }

        pedido.setItens(itens);
        pedido.setValorTotal(valorTotal);

        return pedidoRepository.save(pedido);
    }

    public List<PedidoModel> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public PedidoModel buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public PedidoModel atualizarStatus(Long id, PedidoStatus novoStatus) {
        PedidoModel pedido = buscarPedidoPorId(id);
        if (pedido == null) return null;

        pedido.setStatus(novoStatus);
        return pedidoRepository.save(pedido);
    }

    public void deletarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}

