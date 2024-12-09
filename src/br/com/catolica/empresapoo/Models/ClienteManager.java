package br.com.catolica.empresapoo.Models;

import br.com.catolica.empresapoo.Contracts.IClienteManager;

import java.util.Map;
import java.util.Scanner;

public class ClienteManager implements IClienteManager {

    public void criarCliente(Scanner scanner, Map<Integer, Cliente> clientes) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        int id;

        while (true) {
            System.out.print("ID: ");
            id = scanner.nextInt();
            scanner.nextLine();

            if (clientes.containsKey(id)) {
                System.out.println("ID já está em uso. Por favor, escolha outro ID.");
            } else {
                break;
            }
        }
        Cliente novoCliente = new Cliente(nome, email, telefone, endereco, id);
        clientes.put(id, novoCliente);
        System.out.println("Novo cliente criado: " + nome);
    }
}
