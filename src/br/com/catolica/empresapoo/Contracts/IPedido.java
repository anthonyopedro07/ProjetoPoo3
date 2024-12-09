package br.com.catolica.empresapoo.Contracts;

import br.com.catolica.empresapoo.Enums.StatusPedido;
import br.com.catolica.empresapoo.Models.Produto;

public interface IPedido {

    void adicionarProduto(Produto produto);
    void removerProduto(Produto produto);
    void finalizarPedido();
    double calcularPreco();

}

