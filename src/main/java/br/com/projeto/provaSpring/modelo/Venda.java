package br.com.projeto.provaSpring.modelo;

import java.util.List;

public class Venda {
    private final VendasId id;
    private final int saleId;
    private final List<ItensNota> itens;
    private final String salesmanName;
    private double valorVenda;

    public Venda(VendasId id, int saleId, List<ItensNota> itens, String salesmanName) {
        this.id = id;
        this.saleId = saleId;
        this.itens = itens;
        this.salesmanName = salesmanName;
        setValorVenda();
    }

    public VendasId getId() {
        return id;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public int getSaleId() {
        return saleId;
    }

    public String getSalesmanName(){
        return salesmanName;
    }

    public void setValorVenda() {
        for(ItensNota item : itens){
            this.valorVenda += item.getValorItem();
        }
    }

    public List<ItensNota> getItens() {
        return itens;
    }

    @Override
    public String toString() {
        return "Venda id = " + id + ", saleId = " + saleId +
               " Itens = " + itens +"Valor Venda = "+ getValorVenda()+", salesmanName = " + salesmanName;
    }
}
