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

    public Equipamento(int id, StringProperty nome, DoubleProperty peso, DoubleProperty preco,
                       IntegerProperty quantidade, IntegerProperty numeroDeSerie, Local local, Responsavel responsavel) {
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.preco = preco;
        this.quantidade = quantidade;
        this.numeroDeSerie = numeroDeSerie;
        this.local = local;
        this.responsavel = responsavel;
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
