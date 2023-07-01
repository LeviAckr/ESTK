import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaEstoque {

    private Map<String, Integer> estoque;

    public SistemaEstoque() {
        estoque = new HashMap<>();
    }

    public void adicionarItem(String item, int quantidade) {
        if (estoque.containsKey(item)) {
            int quantidadeAtual = estoque.get(item);
            estoque.put(item, quantidadeAtual + quantidade);
        } else {
            estoque.put(item, quantidade);
        }
        System.out.println("Item adicionado ao estoque.");
    }

    public void removerItem(String item, int quantidade) {
        if (estoque.containsKey(item)) {
            int quantidadeAtual = estoque.get(item);
            if (quantidadeAtual >= quantidade) {
                estoque.put(item, quantidadeAtual - quantidade);
                System.out.println("Item removido do estoque.");
            } else {
                System.out.println("Quantidade insuficiente no estoque.");
            }
        } else {
            System.out.println("Item não encontrado no estoque.");
        }
    }

    public void exibirEstoque() {
        System.out.println("Estoque:");
        if (!estoque.isEmpty()) {
            for (Map.Entry<String, Integer> entry : estoque.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } else {
            System.out.println("O estoque está vazio.");
        }
    }

    public static void main(String[] args) {
        SistemaEstoque sistemaEstoque = new SistemaEstoque();
        Scanner scanner = new Scanner(System.in);

        boolean executando = true;
        while (executando) {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1. Adicionar item ao estoque");
            System.out.println("2. Remover item do estoque");
            System.out.println("3. Exibir estoque");
            System.out.println("4. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do item:");
                    String item = scanner.next();
                    System.out.println("Digite a quantidade:");
                    int quantidadeAdicionar = scanner.nextInt();
                    sistemaEstoque.adicionarItem(item, quantidadeAdicionar);
                    break;
                case 2:
                    System.out.println("Digite o nome do item:");
                    String itemRemover = scanner.next();
                    System.out.println("Digite a quantidade:");
                    int quantidadeRemover = scanner.nextInt();
                    sistemaEstoque.removerItem(itemRemover, quantidadeRemover);
                    break;
                case 3:
                    sistemaEstoque.exibirEstoque();
                    break;
                case 4:
                    executando = false;
                    System.out.println("Saindo do sistema.");
                    break;
                default:
                    System.out.println("Opção inválida. Digite novamente.");
            }
        }

        scanner.close();
    }
}
