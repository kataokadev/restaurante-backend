package com.devs.restaurant.Pedido;

import com.devs.restaurant.Produtos.ProdutosModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tb_pedidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private BigDecimal valor_total;

    @Column
    private PedidoStatus status;

    @Column
    @JoinColumn(name = "produto_id")
    private List<ProdutosModel> produtos;
}
