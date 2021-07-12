package br.com.projeto.provaSpring;

import br.com.projeto.provaSpring.modelo.Cliente;
import br.com.projeto.provaSpring.modelo.Venda;
import br.com.projeto.provaSpring.modelo.Vendedor;
import br.com.projeto.provaSpring.service.ClienteService;
import br.com.projeto.provaSpring.service.VendaService;
import br.com.projeto.provaSpring.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DocumentoSaida {

    private final VendaService vendaService;
    private final ClienteService clienteService;
    private final VendedorService vendedorService;

    public DocumentoSaida(VendaService vendaService,ClienteService clienteService,VendedorService vendedorService){
        this.vendaService = vendaService;
        this.clienteService = clienteService;
        this.vendedorService = vendedorService;
    }

    public String exit(List<Venda> vendas, List<Cliente> clientes, List<Vendedor> vendedores){
        Integer maiorVendaId = vendaService.getMaiorVendaId(vendas);
        String nomePiorVendedor= vendaService.getNomePiorVendedor(vendas);
        Integer quantidadeClientes = clienteService.getNumeroClientes(clientes);
        Integer quantidadeVendedores = vendedorService.getNumeroVendedores(vendedores);
        String solicitado = "QuantidadeClientes,QuantidadeVendedor,IdVendaMaisCara,OPiorVendedor\r\n";
        String resposta = String.format("%20d,%40d,%40d,%25s",quantidadeClientes,quantidadeVendedores, maiorVendaId,nomePiorVendedor+"\r\n");
        return solicitado + resposta;
    }
}
