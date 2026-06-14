package com.devs.restaurant.Cliente;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/criar")
    public ClienteModel criarCliente(@RequestBody ClienteModel clienteModel) {
        return clienteService.criarCliente(clienteModel);
    }

    @GetMapping("/listar")
    public List<ClienteModel> BuscarTodosClientes() {
        return clienteService.buscarClientes();
    }

    @GetMapping("/listar/{id}")
    public ClienteModel buscarClientePorId(@PathVariable("id") Long id) {
        return clienteService.buscarClientePorId(id);
    }

    @PatchMapping("/atualizar/{id}")
    public ClienteModel AtualizarClientePorId(@PathVariable("id") Long id,@RequestBody ClienteModel clienteModel) {
        return clienteService.atualizarCliente(id, clienteModel);
    }

    @DeleteMapping("/deletar/{id}")
    public void DelteClientePorId(@PathVariable("id") Long id) {
        clienteService.deletarCliente(id);
    }

}
