package br.com.projeto.provaSpring.converter;

import br.com.projeto.provaSpring.modelo.ItensNota;
import br.com.projeto.provaSpring.modelo.Venda;
import br.com.projeto.provaSpring.modelo.VendasId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

import static br.com.projeto.provaSpring.modelo.VendasId.VENDA;

@Component
public class ConverterVenda implements Converter<String[], Venda> {

    private static final ConversorItens CONVERSOR_ITENS = new ConversorItens();

    @Override
    public Venda convert(String[] leia) {
        if(leia.length != 4){
            return null;
        }
        int saleID = Integer.parseInt(leia[1]);
        String[] split = leia[2].split(",");
        List<ItensNota> itens = CONVERSOR_ITENS.convert(split);
        String salesmanName = String.valueOf(leia[3]);
        return new Venda(VENDA,saleID,itens,salesmanName);
    }
}
