package br.com.projeto.provaSpring.service;

import br.com.projeto.provaSpring.modelo.Venda;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class VendaService {

    public Integer getMaiorVendaId(List<Venda> vendas) {
        if (vendas == null || vendas.isEmpty()) {
            return null;
        }
        vendas.sort(Comparator.comparing(Venda::getValorVenda));
        return vendas.get(vendas.size() - 1).getSaleId();
    }

    public String getNomePiorVendedor(List<Venda> vendas){
        if (vendas == null || vendas.isEmpty()){
            return null;
        }
        vendas.sort(Comparator.comparing(Venda::getValorVenda));
        return vendas.get(0).getSalesmanName();
    }
}
