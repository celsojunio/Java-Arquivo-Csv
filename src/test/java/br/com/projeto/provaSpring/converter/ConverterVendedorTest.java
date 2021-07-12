package br.com.projeto.provaSpring.converter;

import br.com.projeto.provaSpring.modelo.VendasId;
import br.com.projeto.provaSpring.modelo.Vendedor;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ConverterVendedorTest {

    private final ConverterVendedor converteVendedor;

    public ConverterVendedorTest(ConverterVendedor converteVendedor){
        this.converteVendedor = converteVendedor;
    }

    @Test
    public void testaConverterVendedor() throws IOException {
        String [] seller = {"001","1234567891234","Pedro","50000"};
        Vendedor vendedor = converteVendedor.convert(seller);
        assertNotNull(vendedor);
        assertEquals(VendasId.VENDEDOR,vendedor.getId());
        assertEquals(1234567891234L,vendedor.getCpf());
        assertEquals("Pedro",vendedor.getName());
        assertEquals(50000,vendedor.getSalario(), 0.01);
    }

    @Test
    public void testeVendedorVazio(){
        String [] linha = {};
        Vendedor vendedor = converteVendedor.convert(linha);
        assertNull(vendedor);
    }

    @Test
    public void testeVendedorComMaisItens(){
        String [] linha = {"001","1234567891234","Pedro","50000","Erro"};
        Vendedor vendedor = converteVendedor.convert(linha);
        assertNull(vendedor);
    }

    @Test
    public void testeVendedorComMenosItens(){
        String [] linha = {"001","1234567891234","Pedro"};
        Vendedor vendedor = converteVendedor.convert(linha);
        assertNull(vendedor);
    }

    @Test
    public void testeVendedorSemItens(){
        String [] linha = new String[0];
        Vendedor vendedor = converteVendedor.convert(linha);
        assertNull(vendedor);
    }

}
