package com.devs.restaurant.Produtos;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutosController {

    private final ProdutosService produtosService;

    public ProdutosController(ProdutosService produtosService) {
        this.produtosService = produtosService;
    }

    @PostMapping("/criar")
    public ProdutosModel criarProduto(@RequestBody ProdutosModel produto) {
        return produtosService.criarProduto(produto);
    }

    @GetMapping("/listar")
    public List<ProdutosModel> listarProdutos() {
        return produtosService.listarProdutos();
    }

    @GetMapping("/listar/{id}")
    public ProdutosModel buscarProdutoPorId(@PathVariable Long id) {
        return produtosService.buscarProdutoPorId(id);
    }

    @PatchMapping("/atualizar/{id}")
    public ProdutosModel atualizarProduto(@PathVariable Long id, @RequestBody ProdutosModel produto) {
        return produtosService.atualizarProduto(id, produto);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtosService.deletarProduto(id);
    }
}