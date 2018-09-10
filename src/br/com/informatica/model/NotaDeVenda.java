package br.com.informatica.model;

import java.util.ArrayList;
import java.util.Date;

public class NotaDeVenda {
    // Attributes
    private Cliente cliente;
    private Date DataDeEmissao;
    private ArrayList<Equipamento> produtos;
    private double precoTotal;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataDeEmissao() {
        return DataDeEmissao;
    }

    public void setDataDeEmissao(Date dataDeEmissao) {
        DataDeEmissao = dataDeEmissao;
    }

    public ArrayList<Equipamento> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Equipamento> produtos) {
        this.produtos = produtos;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
}
