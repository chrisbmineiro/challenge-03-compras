package challenge.compras.models;

public class Compras implements Comparable<Compras>{
    private double valorCompra;
    private final String descricaoCompra;

    public Compras(double valorCompra, String descricaoCompra) {
        this.descricaoCompra = descricaoCompra;
        this.valorCompra = valorCompra;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public String getDescricaoCompra() {
        return descricaoCompra;
    }

    @Override
    public String toString() {
        return "Descrição: " + descricaoCompra + " - Valor: R$" + valorCompra;
    }

    @Override
    public int compareTo(Compras outraCompra) {
        // Se o valor desta compra for menor, retorna negativo (ordem crescente)
        return Double.compare(this.valorCompra, outraCompra.valorCompra);
    }
}
