package br.com.projeto.provaSpring.converter;

import br.com.projeto.provaSpring.modelo.ItensNota;
import br.com.projeto.provaSpring.modelo.Venda;
import br.com.projeto.provaSpring.modelo.VendasId;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ConverterVendaTest {

    private ConverterVenda cv;

    public ConverterVendaTest(ConverterVenda converterVenda){
        this.cv = converterVenda;
    }

    @Test
    public void testaVenda(){
        String[] sell = {"003","10","[1-10-100,2-30-2.50,3-40-3.10]","Pedro"};
        Venda venda = cv.convert(sell);
        List<ItensNota> itens = new ArrayList<>();
        itens.add(new ItensNota(1,10,100));
        itens.add(new ItensNota(2,30,2.50));
        itens.add(new ItensNota(3,40,3.10));
        assertNotNull(venda);
        assertNotNull(venda.getSalesmanName());
        assertNotNull(venda.getItens());
        assertEquals(VendasId.VENDA,venda.getId());
        assertEquals(10,venda.getSaleId());
        assertEquals(itens,venda.getItens());
        assertEquals("Pedro",venda.getSalesmanName());
    }

    @Test
    public void testaVendaComMenosItens(){
        String[] sell = {"003","10","[1-10-100,2-30-2.50]","Pedro"};
        Venda venda = cv.convert(sell);
        List<ItensNota> itens = new ArrayList<>();
        itens.add(new ItensNota(1,10,100));
        itens.add(new ItensNota(2,30,2.50));
        assertNotNull(venda);
    }

    @Test
    public void testaVendaComMaisItens() {
        String[] sell = {"003", "10", "[1-10-100,2-30-2.50,3-40-3.10,4-50-2.15,5-60-4.20]", "Pedro"};
        Venda venda = cv.convert(sell);
        List<ItensNota> itens = new ArrayList<>();
        itens.add(new ItensNota(1, 10, 100));
        itens.add(new ItensNota(2, 30, 2.50));
        itens.add(new ItensNota(3, 40, 6.00));
        itens.add(new ItensNota(4, 50, 2.15));
        itens.add(new ItensNota(5, 60, 4.20));

        assertNotNull(itens);
        assertNotNull(venda);
    }

    @Test
    public void testaVendaComMenosPosicao(){
        String[] sell = {"003","10","[1-10-100,2-30-2.50,3-40-3.10]"};
        Venda venda = cv.convert(sell);
        assertNull(venda);
    }
}
