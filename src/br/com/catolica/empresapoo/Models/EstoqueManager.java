package br.com.catolica.empresapoo.Models;

import br.com.catolica.empresapoo.Contracts.IEstoqueManager;
import br.com.catolica.empresapoo.Enums.TipoProduto;

import java.util.Scanner;

public class EstoqueManager implements IEstoqueManager {

    public void adicionarProdutoEstoque(Scanner scanner, Estoque estoque) {
        System.out.print("Nome do Produto: ");
        String nome = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        Produto produto = new Produto(nome, TipoProduto.ELETRONICO, preco, quantidade);
        estoque.adicionarProduto(produto);
        System.out.println("Produto adicionado ao estoque.");
    }

    public void listarProdutos(Estoque estoque) {
        estoque.listarProdutos();
    }
}

