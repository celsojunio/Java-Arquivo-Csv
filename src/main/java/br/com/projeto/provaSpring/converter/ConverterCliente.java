package br.com.projeto.provaSpring.converter;

import br.com.projeto.provaSpring.modelo.Cliente;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static br.com.projeto.provaSpring.modelo.VendasId.CLIENTE;

@Component
public class ConverterCliente implements Converter<String[], Cliente> {

    @Override
    public Cliente convert(String[] leia) {
        if (leia.length != 4) {
            return null;
        }
        long cnpj = Long.parseLong(leia[1]);
        String name = String.valueOf(leia[2]);
        String businessArea = String.valueOf(leia[3]);
        return new Cliente(CLIENTE,cnpj,name,businessArea);
    }
}
