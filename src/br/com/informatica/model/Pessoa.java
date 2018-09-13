package br.com.informatica.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Pessoa {
    // Attributes
    private int id;
    private StringProperty nome  = new SimpleStringProperty();
    private StringProperty endereco = new SimpleStringProperty();

    public Pessoa(){}

    public Pessoa(String nome, String endereco) {
        this.setNome(nome);
        this.setEndereco(endereco);
    }

    public Pessoa(int id, String nome, String endereco) {
        this.setId(id);
        this.setNome(nome);
        this.setEndereco(endereco);
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

    public final StringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getEndereco() {
        return endereco.get();
    }

    public final StringProperty enderecoProperty() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco.set(endereco);
    }
}
