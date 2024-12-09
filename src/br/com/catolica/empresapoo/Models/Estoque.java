package br.com.catolica.empresapoo.Models;

import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private Map<String, Produto> produtos = new HashMap<>();

    public void adicionarProduto(Produto produto) {
        produtos.put(produto.getNome(), produto);
    }

    public Produto buscarProduto(String nomeProduto) {
        for (Produto produto : produtos.values()) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                return produto;
            }
        }
        return null;
    }

    public void removerProduto(String nome) {
        produtos.remove(nome);
    }

    public void listarProdutos() {
        for (Produto produto : produtos.values()) {
            System.out.println(produto.getNome() + ": " + produto.getPreco() + " | " + produto.getQuantidade() + " em estoque");
        }
    }
}


