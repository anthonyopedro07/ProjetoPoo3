package br.com.catolica.empresapoo.Contracts;

import br.com.catolica.empresapoo.Models.Cliente;
import br.com.catolica.empresapoo.Models.Estoque;

import java.util.Map;
import java.util.Scanner;

public interface IPedidoManager {

    void mostrarClientes(Map<Integer, Cliente> clientes);
    void criarPedido(Scanner scanner, Map<Integer, Cliente> clientes, Estoque estoque);
    void mostrarPedidos(Map<Integer, Cliente> clientes);
    void processarPagamento(Scanner scanner, Map<Integer, Cliente> clientes);
}
