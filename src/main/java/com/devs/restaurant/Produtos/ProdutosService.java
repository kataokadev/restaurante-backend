package com.devs.restaurant.Produtos;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosService {

    private final ProdutosRepository produtosRepository;

    public ProdutosService(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    public ProdutosModel criarProduto(ProdutosModel produto) {
        return produtosRepository.save(produto);
    }

    public List<ProdutosModel> listarProdutos() {
        return produtosRepository.findAll();
    }

    public ProdutosModel buscarProdutoPorId(Long id) {
        return produtosRepository.findById(id).orElse(null);
    }

    public ProdutosModel atualizarProduto(Long id, ProdutosModel dadosParciais) {
        ProdutosModel produto = buscarProdutoPorId(id);
        if (produto == null) return null;

        if (dadosParciais.getNome() != null) produto.setNome(dadosParciais.getNome());
        if (dadosParciais.getPreco() != null) produto.setPreco(dadosParciais.getPreco());

        return produtosRepository.save(produto);
    }

    public void deletarProduto(Long id) {
        produtosRepository.deleteById(id);
    }
}