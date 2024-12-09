package br.com.catolica.empresapoo.Models;

import br.com.catolica.empresapoo.Contracts.ICalculavel;
import br.com.catolica.empresapoo.Contracts.IPedido;
import br.com.catolica.empresapoo.Contracts.IFuncoes;
import br.com.catolica.empresapoo.Enums.*;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements IFuncoes, ICalculavel, IPedido {
    private int id;
    private Cliente cliente;
    private List<Produto> produtos = new ArrayList<>();
    private StatusPedido status;

    public Pedido(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.status = StatusPedido.PENDENTE;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public void finalizarPedido() {
        status = StatusPedido.ENVIADO;
    }

    @Override
    public double calcularPreco() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.calcularPreco();
        }
        return total;
    }

    @Override
    public void salvar() {
        System.out.println("Pedido " + id + " salvo.");
    }

    @Override
    public void carregar() {
        System.out.println("Pedido " + id + " carregado.");
    }

    public StatusPedido getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public void mostrarPedido() {
        System.out.println("Pedido ID: " + id + " | Status: " + status);
        for (int i = 0; i < produtos.size(); i++) {
            Produto p = produtos.get(i);
            System.out.println(p.getNome() + ": " + p.getPreco());
        }
    }
}