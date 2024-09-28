package challenge.compras.models;

public class Compras {
    private double valorCompra;
    private String descricaoCompra;

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
        return "Descrição: " + descricaoCompra + ", Valor: R$" + valorCompra;
    }
}
