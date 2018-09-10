package br.com.informatica.model;

import java.util.ArrayList;
import java.util.Date;

public class Loja {
    // Associations
    // Attributes
    private Estoque estoque;
    private ArrayList<Responsavel> funcionarios;
    private ArrayList<Cliente> clientes;
    // Operations
    public final boolean cadastrarFuncionarios () {
        return true;
    }

    public final boolean cadastrarCliente () {
        return true;
    }

    public final void consultarEstoque () {
    }

    public final boolean comprar (Equipamento equipamento, int quantidade) {
        return true;
    }

    public final boolean vender (Equipamento equipamento, int quantidade) {
        return true;
    }

    public final NotaDeVenda emitirNotaDeVenda (Cliente cliente, Date data, ArrayList<Equipamento> equipamentos, double precoTotal) {
        NotaDeVenda nota = null;

        return nota;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public ArrayList<Responsavel> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Responsavel> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
}
