package br.com.catolica.empresapoo.Models;
import br.com.catolica.empresapoo.Contracts.*;
import br.com.catolica.empresapoo.Enums.*;

public abstract class Produto implements ICalculavel, IFuncoes {
    private String nome;
    private TipoProduto tipo;
    private double preco;
    private int quantidade;

    public Produto(String nome, TipoProduto tipo, double preco, int quantidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public double calcularPreco() {
        return preco * quantidade;
    }

    @Override
    public void salvar() {
        System.out.println("Produto " + nome + " salvo no sistema.");
    }

    @Override
    public void carregar() {
        System.out.println("Produto " + nome + " carregado do sistema.");
    }

    public String getNome() {
        return nome;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
