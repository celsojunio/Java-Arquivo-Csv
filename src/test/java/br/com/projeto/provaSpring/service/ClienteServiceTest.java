package br.com.projeto.provaSpring.service;

import br.com.projeto.provaSpring.modelo.VendasId;
import br.com.projeto.provaSpring.modelo.Cliente;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteServiceTest {

    ClienteService clienteService = new ClienteService();

    @Test
    public void testGetNumeroClientesComClienteNull(){
        Integer id = clienteService.getNumeroClientes(null);
        assertNull(id);
    }

    @Test
    public void testGetNumeroClientesEmpty(){
        List<Cliente> clientes = new ArrayList<>();
        Integer id = clienteService.getNumeroClientes(clientes);
        assertNull(id);
    }

    @Test
    public void testGetNumeroClientesComMaisClientes(){
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(VendasId.CLIENTE,2345675434544345L,"Dilnei","Construção"));
        clientes.add(new Cliente(VendasId.CLIENTE,23456712651416L,"Jefferson","Comercio"));
        clientes.add(new Cliente(VendasId.CLIENTE,254596134544345L,"Eric","Financeiro"));
        clientes.add(new Cliente(VendasId.CLIENTE,123456634544345L,"Natan","Lojista"));
        clientes.add(new Cliente(VendasId.CLIENTE,23456754345445L,"Alexandre","Varegista"));
        Integer id = clienteService.getNumeroClientes(clientes);
        assertNotNull(id);
        assertEquals(5,clientes.size());
    }
}
