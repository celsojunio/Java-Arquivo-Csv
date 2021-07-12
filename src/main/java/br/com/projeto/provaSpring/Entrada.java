package br.com.projeto.provaSpring;

import br.com.projeto.provaSpring.converter.ConverterCliente;
import br.com.projeto.provaSpring.converter.ConverterVenda;
import br.com.projeto.provaSpring.converter.ConverterVendedor;
import br.com.projeto.provaSpring.modelo.VendasId;
import br.com.projeto.provaSpring.modelo.Cliente;
import br.com.projeto.provaSpring.modelo.Venda;
import br.com.projeto.provaSpring.modelo.Vendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class Entrada {
    private static final String IN = "/data/in";
    private static final String OUT = "/data/out";
    private static final String HOMEPATH = System.getProperty("user.home");

    private final ConverterVendedor CONVERTE_VENDEDOR;
    private final ConverterCliente CONVERTE_CLIENTE;
    private final ConverterVenda CONVERTE_VENDA;

    private final DocumentoSaida docSaida;

    public Entrada(ConverterVendedor converte_vendedor, ConverterCliente converte_cliente, ConverterVenda converte_venda,
    DocumentoSaida docSaida) {
        CONVERTE_VENDEDOR = converte_vendedor;
        CONVERTE_CLIENTE = converte_cliente;
        CONVERTE_VENDA = converte_venda;
        this.docSaida = docSaida;
    }

    @Scheduled(fixedRate = 5000)
    public void start()throws IOException {
        File in = new File(HOMEPATH + IN);
        File[] files = in.listFiles();
        assert files != null;
        for (File file : files) {
            this.processFile(file);
        }
    }

    private void processFile(File file) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(file));
        String linha = br.readLine();
        List<Vendedor> vendedores = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        List<Venda> vendas = new ArrayList<>();
        while(linha != null) {// Enquanto tiver próxima linha, segue o loop.
            String[] leia = linha.split("ç");
            VendasId id = VendasId.of(Integer.parseInt(leia[0]));
            switch(id){
                case VENDEDOR:
                    vendedores.add(CONVERTE_VENDEDOR.convert(leia));
                    break;
                case CLIENTE:
                    clientes.add(CONVERTE_CLIENTE.convert(leia));
                    break;
                case VENDA:
                    vendas.add(CONVERTE_VENDA.convert(leia));
            }
            linha = br.readLine();
        }
        br.close();
        this.writeOutput(file, clientes, vendedores, vendas);
    }
    private void writeOutput(File file, List<Cliente> clientes, List<Vendedor> vendedores,List<Venda> vendas) throws IOException {
        File out = new File(HOMEPATH + OUT + "/"+file.getName());
        Writer fw = new FileWriter(out.getAbsolutePath());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(docSaida.exit(vendas,clientes,vendedores));
        bw.close();
        file.delete();
    }
}







//    @PostConstruct
//    public void inicio(){
//        start();
//        System.out.println(itensConverter.convert("FEIJAO"));
//        System.out.println("Iniciando");
//    }
