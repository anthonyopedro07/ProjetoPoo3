package br.com.catolica.empresapoo.Contracts;

import br.com.catolica.empresapoo.Models.Estoque;

import java.util.Scanner;

public interface IEstoqueManager {
    void adicionarProdutoEstoque(Scanner scanner, Estoque estoque);
}
