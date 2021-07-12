package br.com.projeto.provaSpring.modelo;


public enum VendasId {
    VENDEDOR(1),
    CLIENTE(2),
    VENDA(3);

    private int id;

    VendasId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public static VendasId of(int id){
        for(VendasId vendasId : VendasId.values()) {
            if(vendasId.getId() == id){
                return vendasId;
            }
        }
        return null;
    }
}
