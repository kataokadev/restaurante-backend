package com.devs.restaurant.Pedido;

import com.devs.restaurant.Cliente.ClienteModel;
import com.devs.restaurant.ItemPedido.ItemPedidoModel;
import com.devs.restaurant.Produtos.ProdutosModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_pedidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"cliente", "itens"})
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PedidoStatus status;

    @CreationTimestamp
    @Column(name = "data_pedido", nullable = false,  updatable = false)
    private LocalDateTime dataPedido;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedidoModel> itens = new ArrayList<>();
}