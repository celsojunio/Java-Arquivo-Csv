package br.com.projeto.provaSpring.service;

import br.com.projeto.provaSpring.modelo.VendasId;
import br.com.projeto.provaSpring.modelo.ItensNota;
import br.com.projeto.provaSpring.modelo.Venda;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VendaServiceTest {

    private VendaService vendaService = new VendaService();

    @Test
    public void testGetMaiorVendaIdWhenVendasNull() {
        Integer id = vendaService.getMaiorVendaId(null);
        assertNull(id);
    }

    @Test
    public void testGetMaiorVendaIdWhenVendasEmpty() {
        List<Venda> vendas = new ArrayList<>();
        Integer id = vendaService.getMaiorVendaId(vendas);
        assertNull(id);
    }

    @Test
    public void testGetMaiorVendaIdWhenVendaEq1() {
        List<Venda> vendas = new ArrayList<>();
        vendas.add(new Venda(VendasId.VENDA, 12, new ArrayList<>(), "darlan"));
        Integer id = vendaService.getMaiorVendaId(vendas);
        assertNotNull(id);
        assertEquals(new Integer(12), id);
    }

    @Test
    public void testGetMaiorVendaIdQuandoUmaVendaNaoTemItens() {
        List<Venda> vendas = new ArrayList<>();
        vendas.add(new Venda(VendasId.VENDA, 12, new ArrayList<>(), "Zezinho"));
        List<ItensNota> itens = new ArrayList<>();
        itens.add(new ItensNota(1,10,100));
        itens.add(new ItensNota(2,30,2.50));
        itens.add(new ItensNota(3,40,3.10));
        vendas.add(new Venda(VendasId.VENDA, 13, itens, "Zezinho"));
        Integer id = vendaService.getMaiorVendaId(vendas);
        assertNotNull(id);
        assertEquals(Integer.valueOf(13), id);
    }

    @Test
    public void testGetMaiorVendaId() {
        List<Venda> vendas = new ArrayList<>();
        List<ItensNota> itensA = new ArrayList<>();
        itensA.add(new ItensNota(1,10,100));
        itensA.add(new ItensNota(2,30,2.51));
        itensA.add(new ItensNota(3,40,3.10));
        vendas.add(new Venda(VendasId.VENDA, 12, itensA, "Zezinho"));
        List<ItensNota> itensB = new ArrayList<>();
        itensB.add(new ItensNota(1,10,100));
        itensB.add(new ItensNota(2,30,2.50));
        itensB.add(new ItensNota(3,40,3.10));
        vendas.add(new Venda(VendasId.VENDA, 13, itensB, "Zezinho"));
        Integer id = vendaService.getMaiorVendaId(vendas);
        assertNotNull(id);
        assertEquals(Integer.valueOf(12), id);
    }

    @Test
    public void testGetNomePiorVendedorUmaVenda(){
        List<Venda> vendas = new ArrayList<>();
        List<ItensNota> itensA = new ArrayList<>();
        itensA.add(new ItensNota(1,10,100));
        itensA.add(new ItensNota(2,30,2.51));
        itensA.add(new ItensNota(3,40,3.10));
        vendas.add(new Venda(VendasId.VENDA, 12, itensA, "Zezinho"));
        String nome = vendaService.getNomePiorVendedor(vendas);
        assertEquals("Zezinho",nome);
    }

    @Test
    public void testGetNomePiorVendedorDuasVenda(){
        List<Venda> vendas = new ArrayList<>();
        List<ItensNota> itensA = new ArrayList<>();
        itensA.add(new ItensNota(1,10,100));
        itensA.add(new ItensNota(2,30,2.51));
        itensA.add(new ItensNota(3,40,3.10));
        vendas.add(new Venda(VendasId.VENDA, 12, itensA, "Zezinho"));
        List<ItensNota> itensB = new ArrayList<>();
        itensB.add(new ItensNota(1,10,100));
        itensB.add(new ItensNota(2,30,2.50));
        itensB.add(new ItensNota(3,40,3.10));
        vendas.add(new Venda(VendasId.VENDA, 13, itensB, "Paulinho"));
        String nome = vendaService.getNomePiorVendedor(vendas);
        assertNotEquals("Zezinho",nome);
        assertEquals("Paulinho",nome);
    }
}
