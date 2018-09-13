package br.com.informatica.model;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Cliente extends Pessoa {
    // Attributes
    private StringProperty cpf = new SimpleStringProperty();

    public Cliente() {}

    public Cliente(String nome, String endereco, String cpf) {
        super(nome, endereco);
        setCpf(cpf);
    }

    public Cliente(int id, String nome, String endereco, String cpf) {
        super(id, nome, endereco);
        setCpf(cpf);
    }

    public String getCpf() {
        return cpf.get();
    }

    public final StringProperty cpfProperty() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf.set(cpf);
    }

    @Override
    public String toString() {
        return getNome();
    }
}
