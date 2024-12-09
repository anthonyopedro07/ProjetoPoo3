package br.com.catolica.empresapoo.Models;

import br.com.catolica.empresapoo.Enums.TipoPagamento;

public class Pagamento {
    private TipoPagamento tipo;
    private double valor;

    public Pagamento(TipoPagamento tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public TipoPagamento getTipo() {
        return tipo;
    }

    public void processarPagamento() {
        System.out.println("Pagamento de " + valor + " processado via " + tipo);
    }
}

