package br.com.catolica.empresapoo.Models;
public class Funcionario extends Pessoa  {

    private String cargo;

    public Funcionario(String nome, String email, String telefone, String endereco, int id,String cargo) {
        super(nome, email, telefone, endereco, id);
        this.cargo = cargo;
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("Funcionario: " + nome + " | Cargo: " + cargo + " | ID: " + id);
    }
}
