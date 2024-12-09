package br.com.catolica.empresapoo.Models;

import br.com.catolica.empresapoo.Contracts.IPedidoManager;
import br.com.catolica.empresapoo.Enums.StatusPedido;
import br.com.catolica.empresapoo.Enums.TipoPagamento;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class PedidoManager implements IPedidoManager {

    public void mostrarClientes(Map<Integer, Cliente> clientes) {
        for (Cliente cliente : clientes.values()) {
            cliente.mostrarInformacoes();
        }
    }

    public void criarPedido(Scanner scanner, Map<Integer, Cliente> clientes, Estoque estoque) {
        System.out.print("Digite o ID do Cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = clientes.get(idCliente);
        if (cliente != null) {
            Pedido pedido = new Pedido(new Random().nextInt(1000), cliente);
            cliente.adicionarPedido(pedido);
            System.out.println("Pedido criado para o cliente: " + cliente.getNome());

            estoque.listarProdutos();
            System.out.print("Digite o nome do produto a ser adicionado ao pedido: ");
            String nomeProduto = scanner.nextLine();

            Produto produto = estoque.buscarProduto(nomeProduto);
            if (produto != null) {
                pedido.adicionarProduto(produto);
                System.out.println("Produto adicionado ao pedido.");
            } else {
                System.out.println("Produto não encontrado.");
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void mostrarPedidos(Map<Integer, Cliente> clientes) {
        for (Cliente cliente : clientes.values()) {
            System.out.println("Pedidos de " + cliente.getNome() + ":");
            if (cliente.getPedidos().isEmpty()) {
                System.out.println("Nenhum pedido encontrado.");
            } else {
                for (Pedido pedido : cliente.getPedidos()) {
                    pedido.mostrarPedido();
                }
            }
        }
    }

    public void processarPagamento(Scanner scanner, Map<Integer, Cliente> clientes) {
        System.out.print("Digite o ID do Cliente para o pagamento: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = clientes.get(idCliente);
        if (cliente != null) {
            System.out.println();
            System.out.print("Digite o ID do Pedido para o pagamento: ");
            int idPedido = scanner.nextInt();
            scanner.nextLine();

            Pedido pedido = null;

            List<Pedido> pedidos = cliente.getPedidos();
            for (int i = 0; i < pedidos.size(); i++) {
                Pedido p = pedidos.get(i);
                if (p.getId() == idPedido && p.getStatus() == StatusPedido.PENDENTE) {
                    pedido = p;
                    break;
                }
            }

            if (pedido != null) {
                System.out.println("Pedido encontrado: " + idPedido);
                System.out.println("Total a pagar: R$ " + pedido.calcularPreco());
                System.out.println("Escolha o tipo de pagamento:");
                System.out.println("1. Crédito");
                System.out.println("2. Débito");
                System.out.println("3. Boleto");
                System.out.println("4. PIX");
                System.out.print("Opção: ");
                int tipoPagamento = scanner.nextInt();
                scanner.nextLine();

                TipoPagamento tipo = null;
                switch (tipoPagamento) {
                    case 1:
                        tipo = TipoPagamento.CREDITO;
                        break;
                    case 2:
                        tipo = TipoPagamento.DEBITO;
                        break;
                    case 3:
                        tipo = TipoPagamento.BOLETO;
                        break;
                    case 4:
                        tipo = TipoPagamento.PIX;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        return;
                }

                Pagamento pagamento = new Pagamento(tipo, pedido.calcularPreco());
                pagamento.processarPagamento();
                System.out.println("Pagamento processado com sucesso!");

                pedido.finalizarPedido();
            } else {
                System.out.println("Pedido não encontrado ou não está pendente.");
            }
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}

