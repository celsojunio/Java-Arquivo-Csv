package br.com.projeto.provaSpring.converter;


import br.com.projeto.provaSpring.modelo.Cliente;
import br.com.projeto.provaSpring.modelo.VendasId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConverterClienteTest {

    private ConverterCliente testa;

    public ConverterClienteTest(ConverterCliente testa){
        this.testa = testa;
    }

    @Test
    public void testeCliente(){
        String [] linha = {"002","2345675434544345","Jose da Silva","Rural"};
        Cliente cliente = testa.convert(linha);
        assertNotNull(cliente);
        assertEquals(VendasId.CLIENTE,cliente.getId());
        assertEquals(2345675434544345L, cliente.getCnpj());
        assertEquals("Jose da Silva",cliente.getName());
        assertEquals("Rural",cliente.getBusinessArea());
    }

    @Test
    public void testeClienteVazio(){
        String [] linha = {};
        Cliente cliente = testa.convert(linha);
        assertNull(cliente);
    }

    @Test
    public void testeClienteComMaisItens(){
        String [] linha = {"002","2345675434544345","Jose da Silva","Rural","Erro"};
        Cliente cliente = testa.convert(linha);
        assertNull(cliente);
    }

    @Test
    public void testeClienteComMenosItens(){
        String [] linha = {"002","2345675434544345","Jose da Silva"};
        Cliente cliente = testa.convert(linha);
        assertNull(cliente);
    }

    @Test
    public void testeClienteSemItens(){
        String [] linha = new String[0];
        Cliente cliente = testa.convert(linha);
        assertNull(cliente);
    }
}
