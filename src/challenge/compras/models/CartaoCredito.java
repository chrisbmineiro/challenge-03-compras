package challenge.compras.models;

public class CartaoCredito {
    private double limiteDisponivel;
    private double valorTotal;

    public CartaoCredito(double limiteDisponivel) {
        this.limiteDisponivel = limiteDisponivel;
        this.valorTotal = 0;
    }

    public double getLimiteDisponivel() {
        return limiteDisponivel;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public boolean processarCompra(Compras compra){
        if (compra.getValorCompra() <= limiteDisponivel) {
            limiteDisponivel -= compra.getValorCompra();
            valorTotal += compra.getValorCompra();
            System.out.println("Compra realizada: " + compra);
            return true;
        } else {
            System.out.println("Compra não realizada. Valor excede o limite disponível do cartão.\n");
            return false;
        }
    }
}
