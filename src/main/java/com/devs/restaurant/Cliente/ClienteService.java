package com.devs.restaurant.Cliente;

import com.devs.restaurant.Pedido.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteModel criarCliente(ClienteModel clienteModel) {
        return clienteRepository.save(clienteModel);
    }

    public List<ClienteModel> buscarClientes() {
        return clienteRepository.findAll();
    }

    public ClienteModel buscarClientePorId(Long idCliente) {
        return clienteRepository.findById(idCliente).orElse(null);
    }

    public ClienteModel atualizarCliente(Long id, ClienteModel dadosParciais) {
        ClienteModel cliente = buscarClientePorId(id);
        if (cliente == null) {
            return null;
        }
        if (dadosParciais.getNome() != null)
            cliente.setNome(dadosParciais.getNome());
        if (dadosParciais.getTelefone() != null)
            cliente.setTelefone(dadosParciais.getTelefone());
        return clienteRepository.save(cliente);
    }

    public void deletarCliente(Long idCliente) {
        clienteRepository.deleteById(idCliente);
    }

}
