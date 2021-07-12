package br.com.projeto.provaSpring.modelo;

public class Vendedor {

    private final VendasId id;
    private final long cpf;
    public final String name;
    private final double salario;

    public Vendedor(VendasId id, long cpf, String name, String salario){
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.salario = Double.parseDouble(salario);
    }

    public VendasId getId() {
        return id;
    }

    public long getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Vendedor Id = " + id + ", Cpf = " + cpf + ", Nome = " + name + ", Salário = " + salario + ']';
    }

}
