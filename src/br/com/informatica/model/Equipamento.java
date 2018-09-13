package br.com.informatica.model;

import javafx.beans.property.*;

public class Equipamento {
    // Attributes
    private int id;
    private StringProperty nome = new SimpleStringProperty();
    private StringProperty peso = new SimpleStringProperty();
    private StringProperty preco = new SimpleStringProperty();
    private StringProperty quantidade = new SimpleStringProperty();
    private StringProperty numeroDeSerie = new SimpleStringProperty();
    private Local local;
    private Responsavel responsavel;

    public Equipamento(){}

    public Equipamento(int id, String nome, String peso, String preco, String quantidade, String numeroDeSerie, Local local, Responsavel responsavel) {
        setId(id);
        setNome(nome);
        setPeso(peso);
        setPreco(preco);
        setQuantidade(quantidade);
        setNumeroDeSerie(numeroDeSerie);
        this.local = local;
        this.responsavel = responsavel;
    }

    public Equipamento(int id, String nome) {
        setId(id);
        setNome(nome);
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

    public String getPeso() {
        return peso.get();
    }

    public StringProperty pesoProperty() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso.set(peso);
    }

    public String getPreco() {
        return preco.get();
    }

    public StringProperty precoProperty() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco.set(preco);
    }

    public String getQuantidade() {
        return quantidade.get();
    }

    public StringProperty quantidadeProperty() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade.set(quantidade);
    }

    public String getNumeroDeSerie() {
        return numeroDeSerie.get();
    }

    public StringProperty numeroDeSerieProperty() {
        return numeroDeSerie;
    }

    public void setNumeroDeSerie(String numeroDeSerie) {
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

    @Override
    public String toString() {
        return this.getNome() + "\t  x" + this.getQuantidade() + "\t\t1x R$" + this.getPreco();
    }
}
