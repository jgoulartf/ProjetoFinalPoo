package br.com.informatica.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Equipamento {
    // Attributes
    private int id;
    private StringProperty nome;
    private DoubleProperty peso;
    private DoubleProperty preco;
    private IntegerProperty quantidade;
    private IntegerProperty numeroDeSerie;
    private Local local;
    private Responsavel responsavel;

    public Equipamento(){}

    public Equipamento(int id, String nome, Double peso, Double preco,
                       Integer quantidade, Integer numeroDeSerie, Local local, Responsavel responsavel)
    {
        this.setNome(nome);
        this.setPeso(peso);
        this.setPreco(preco);
        this.setQuantidade(quantidade);
        this.setNumeroDeSerie(numeroDeSerie);
        this.setLocal(local);
        this.setResponsavel(responsavel);
    }

    public Equipamento(String nome) {
        setNome(nome);
    }

    public Equipamento(int id, String nome, Double peso, Double preco,
                       Integer quantidade, Integer numeroDeSerie)
    {
        this.setNome(nome);
        this.setPeso(peso);
        this.setPreco(preco);
        this.setQuantidade(quantidade);
        this.setNumeroDeSerie(numeroDeSerie);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome.get();
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public double getPeso() {
        return peso.get();
    }

    public DoubleProperty pesoProperty() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso.set(peso);
    }

    public double getPreco() {
        return preco.get();
    }

    public DoubleProperty precoProperty() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco.set(preco);
    }

    public int getQuantidade() {
        return quantidade.get();
    }

    public IntegerProperty quantidadeProperty() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade.set(quantidade);
    }

    public int getNumeroDeSerie() {
        return numeroDeSerie.get();
    }

    public IntegerProperty numeroDeSerieProperty() {
        return numeroDeSerie;
    }

    public void setNumeroDeSerie(int numeroDeSerie) {
        this.numeroDeSerie.set(numeroDeSerie);
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }
}
