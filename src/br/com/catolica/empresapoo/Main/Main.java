package br.com.catolica.empresapoo.Main;

import br.com.catolica.empresapoo.Enums.StatusPedido;
import br.com.catolica.empresapoo.Enums.TipoPagamento;
import br.com.catolica.empresapoo.Enums.TipoProduto;
import br.com.catolica.empresapoo.Models.*;

import java.util.*;



import java.util.*;

public class Main {
    static Map<Integer, Cliente> clientes = new HashMap<>();
    static Estoque estoque = new Estoque();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Anthonyo", "anthonyo@email.com", "(83)99990-4023", "Rua Isaac Moreira", 1);
        Cliente cliente2 = new Cliente("Maria", "maria@email.com", "(83)8132-4023", "Rua Fagundes de Lira", 2);
        clientes.put(cliente1.getId(), cliente1);
        clientes.put(cliente2.getId(), cliente2);

        Produto produto1 = new Produto("Celular", TipoProduto.ELETRONICO, 1500, 10);
        Produto produto2 = new Produto("Camiseta", TipoProduto.VESTUARIO, 50, 50);
        estoque.adicionarProduto(produto1);
        estoque.adicionarProduto(produto2);

        // Criando instâncias dos gerenciadores
        ClienteManager clienteManager = new ClienteManager();
        PedidoManager pedidoManager = new PedidoManager();
        EstoqueManager estoqueManager = new EstoqueManager();

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Mostrar Clientes");
            System.out.println("2. Adicionar Produto ao Estoque");
            System.out.println("3. Criar Cliente");
            System.out.println("4. Criar Pedido");
            System.out.println("5. Listar Produtos");
            System.out.println("6. Listar Pedidos");
            System.out.println("7. Pagamento");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consome a nova linha

            switch (opcao) {
                case 1:
                    pedidoManager.mostrarClientes(clientes);
                    break;
                case 2:
                    estoqueManager.adicionarProdutoEstoque(scanner, estoque);
                    break;
                case 3:
                    clienteManager.criarCliente(scanner, clientes);
                    break;
                case 4:
                    pedidoManager.criarPedido(scanner, clientes, estoque);
                    break;
                case 5:
                    estoqueManager.listarProdutos(estoque);
                    break;
                case 6:
                    pedidoManager.mostrarPedidos(clientes);
                    break;
                case 7:
                    pedidoManager.processarPagamento(scanner, clientes);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}