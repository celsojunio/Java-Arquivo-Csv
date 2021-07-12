package br.com.projeto.provaSpring.converter;

import br.com.projeto.provaSpring.modelo.ItensNota;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConversorItens implements Converter<String[],List<ItensNota>> {

    @Override
    public List<ItensNota> convert(String[] leia) {
        List<ItensNota> itensNota = new ArrayList<>();
        for(String string: leia) {
            String [] valor;
            valor = string.split("-");
            int value0 = parseInt(valor[0]);
            int value1 = parseInt(valor[1]);
            double value2 = parseDouble(valor[2]);
            ItensNota value = new ItensNota(value0, value1, value2);
            itensNota.add(value);
        }
        return itensNota;
    }

    public int parseInt(String strg) {
        return Integer.parseInt(strg.replace("[", ""));
    }

    public double parseDouble(String strg) {
        return Double.parseDouble(strg.replace("]", ""));
    }
}
