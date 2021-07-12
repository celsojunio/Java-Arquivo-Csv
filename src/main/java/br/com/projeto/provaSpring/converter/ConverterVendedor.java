package br.com.projeto.provaSpring.converter;

import br.com.projeto.provaSpring.modelo.Vendedor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static br.com.projeto.provaSpring.modelo.VendasId.VENDEDOR;

@Component
public class ConverterVendedor implements Converter<String[], Vendedor> {

    @Override
    public Vendedor convert(String[] leia) {
        if(leia.length != 4){
            return null;
        }
        long cpf = Long.parseLong(leia[1]);
        String name = String.valueOf(leia[2]);
        String salary = String.valueOf(leia[3]);
        return new Vendedor(VENDEDOR,cpf,name,salary);
    }
}
