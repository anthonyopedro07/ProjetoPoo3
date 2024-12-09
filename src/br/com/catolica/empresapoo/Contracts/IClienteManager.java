package br.com.catolica.empresapoo.Contracts;

import br.com.catolica.empresapoo.Models.Cliente;

import java.util.Map;
import java.util.Scanner;

public interface IClienteManager {
    void criarCliente(Scanner scanner, Map<Integer, Cliente> clientes);
}
