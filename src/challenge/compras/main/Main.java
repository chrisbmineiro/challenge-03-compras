package challenge.compras.main;

import challenge.compras.models.CartaoCredito;
import challenge.compras.models.Compras;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o limite do cartão:");
        double limiteCartao = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha

        CartaoCredito cartao = new CartaoCredito(limiteCartao);
        List<Compras> listaDeCompras = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            // Capturando os dados da compra
            System.out.println("Digite a descrição da compra:");
            String descricaoCompra = scanner.nextLine();
            System.out.println("Digite o valor da compra:");
            double valorCompra = scanner.nextDouble();
            scanner.nextLine(); // Consumir a nova linha deixada pelo nextDouble()

            // Criando a compra e processando
            Compras compra = new Compras(valorCompra, descricaoCompra);
            if (cartao.processarCompra(compra)) {  // Só adicionar à lista se a compra for bem-sucedida
                listaDeCompras.add(compra);
            }

            // Verificar se o usuário deseja continuar
            System.out.println("Digite 1 para continuar ou 0 para sair");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha deixada pelo nextInt()

            if (escolha == 0) {
                continuar = false;
            }
        }
        // Ordenando os itens em ordem crescente
        Collections.sort(listaDeCompras);

        // Exibir total de compras
        if (!listaDeCompras.isEmpty()) {
            System.out.println("********************************\n");
            System.out.println(listaDeCompras.size() > 1 ? "Compras realizadas: " : "Compra realizada: ");
            for (Compras compra : listaDeCompras) {
                System.out.println(compra); // Isso vai usar o método toString() de Compras
            }
        } else {
            System.out.println("Nenhuma compra foi realizada.");
        }
        System.out.println("\n********************************");
        System.out.println("\nValor total das compras: R$" + cartao.getValorTotal());
        System.out.println("Limite restante do cartão: R$" + cartao.getLimiteDisponivel());

        scanner.close(); // Fechar o Scanner
    }
}
