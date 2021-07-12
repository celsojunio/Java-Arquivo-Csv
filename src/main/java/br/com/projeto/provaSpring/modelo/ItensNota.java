package br.com.projeto.provaSpring.modelo;

import java.util.Objects;

public class ItensNota{
    private final int itemId;
    private final int itemQuantity;
    private final double itemPrice;

    public ItensNota(int itemId, int itemQuantity, double itemPrice){
       this.itemId = itemId;
       this.itemQuantity = itemQuantity;
       this.itemPrice = itemPrice;
    }

    public double getValorItem(){
        return itemQuantity * itemPrice;
    }

    @Override
    public String toString() {
        return "[ItemId = " + itemId + ", ItemQuantity = " + itemQuantity + ", ItemPrice = " + itemPrice +  "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItensNota itensNota = (ItensNota) o;
        return itemId == itensNota.itemId &&
                itemQuantity == itensNota.itemQuantity &&
                Double.compare(itensNota.itemPrice, itemPrice) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemQuantity, itemPrice);
    }
}
