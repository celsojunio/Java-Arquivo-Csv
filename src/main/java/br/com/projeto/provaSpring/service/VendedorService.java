package br.com.projeto.provaSpring.service;

import br.com.projeto.provaSpring.modelo.Vendedor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorService {

    public Integer getNumeroVendedores(List<Vendedor> vendedores) {
        if (vendedores == null || vendedores.isEmpty()) {
            return null;
        }
        return vendedores.size();
    }
}