package br.com.catolica.empresapoo.Models;
import br.com.catolica.empresapoo.Contracts.*;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa implements INotificavel {

    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente(String nome, String email, String telefone, String endereco, int id) {
        super(nome, email, telefone, endereco, id);
    }

    @Override
    public void enviarNotificacao(String mensagem) {
        System.out.println("Notificação para " + nome + ": " + mensagem);
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("Cliente: " + nome + " | Email: " + email + " | ID: " + id);
    }


}
