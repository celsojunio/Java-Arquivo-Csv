package br.com.projeto.provaSpring.modelo;

public class Cliente {
    private final VendasId id;
    private final long cnpj;
    private final String name;
    private final String businessArea;

    public Cliente(VendasId id, long cnpj, String name, String businessArea){
        this.id = id;
        this.cnpj = cnpj;
        this.name = name;
        this.businessArea = businessArea;
    }

    public VendasId getId() {
        return id;
    }

    public long getCnpj() {
        return cnpj;
    }

    public String getName() {
        return name;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    @Override
    public String toString() {
        return "Cliente  Id = " + id + ", Cnpj = " + cnpj + ", Name = " + name + ", BusinessArea = " + businessArea;
    }
}
