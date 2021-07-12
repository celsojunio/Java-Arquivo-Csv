package br.com.projeto.provaSpring.service;


import br.com.projeto.provaSpring.modelo.VendasId;
import br.com.projeto.provaSpring.modelo.Vendedor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VendedorServiceTest {

    VendedorService vendedorService = new VendedorService();

    @Test
    public void testGetNumeroVendedorComClienteNull(){
        Integer id = vendedorService.getNumeroVendedores(null);
        assertNull(id);
    }

    @Test
    public void testGetNumeroVendedorEmpty(){
        List<Vendedor> vendedores = new ArrayList<>();
        Integer id = vendedorService.getNumeroVendedores(vendedores);
        assertNull(id);
        assertEquals(0,vendedores.size());
    }

    @Test
    public void testGetNumeroClientesComMaisClientes(){
        List<Vendedor> vendedores = new ArrayList<>();
        vendedores.add(new Vendedor(VendasId.VENDEDOR,2345675434544345L,"Dilnei","1250"));
        vendedores.add(new Vendedor(VendasId.VENDEDOR,23456712651416L,"Jefferson","1750"));
        vendedores.add(new Vendedor(VendasId.VENDEDOR,254596134544345L,"Eric","2000"));
        vendedores.add(new Vendedor(VendasId.VENDEDOR,123456634544345L,"Natan","1500"));
        vendedores.add(new Vendedor(VendasId.VENDEDOR,23456754345445L,"Alexandre","5000"));
        Integer id = vendedorService.getNumeroVendedores(vendedores);
        assertNotNull(id);
        assertEquals(5,vendedores.size());
    }
}
