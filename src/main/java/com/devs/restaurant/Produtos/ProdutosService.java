package com.devs.restaurant.Produtos;

import org.springframework.stereotype.Service;

@Service
public class ProdutosService {

    private final ProdutosRepository produtosRepository;

    public ProdutosService (ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }
}
