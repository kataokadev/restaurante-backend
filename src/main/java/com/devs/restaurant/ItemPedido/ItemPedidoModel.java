package com.devs.restaurant.ItemPedido;

import com.devs.restaurant.Pedido.PedidoModel;
import com.devs.restaurant.Produtos.ProdutosModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_itens_pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "pedido")
public class ItemPedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    @JsonIgnore
    private PedidoModel pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private ProdutosModel produto;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(name = "preco_unitario", nullable = false)
    private BigDecimal precoUnitario;

    @Transient
    public BigDecimal getSubtotal() {
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }
}
