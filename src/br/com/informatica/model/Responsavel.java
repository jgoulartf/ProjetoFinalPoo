package br.com.informatica.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Responsavel extends Pessoa {
    // Attributes
    private StringProperty telefone = new SimpleStringProperty();

    public Responsavel(){}

    public Responsavel(String nome, String endereco, String telefone) {
        super(nome, endereco);
        setTelefone(telefone);
    }

    public Responsavel(int id, String nome, String endereco, String telefone) {
        super(id, nome, endereco);
        setTelefone(telefone);
    }

    public String getTelefone() {
        return telefone.get();
    }

    public StringProperty telefoneProperty() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone.set(telefone);
    }

    public String toString() {
        return this.getNome();
    }

}
