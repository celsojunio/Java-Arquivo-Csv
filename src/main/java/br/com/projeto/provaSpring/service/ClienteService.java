package br.com.projeto.provaSpring.service;

import br.com.projeto.provaSpring.modelo.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    public Integer getNumeroClientes(List<Cliente> clientes) {
        if (clientes == null || clientes.isEmpty()) {
            return null;
        }
        return clientes.size();
    }
}
