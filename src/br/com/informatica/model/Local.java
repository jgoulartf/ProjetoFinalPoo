package br.com.informatica.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Local {
    // Attributes
    private int id;
    private StringProperty codigoDaPrateleira = new SimpleStringProperty();
    private StringProperty numeroDaSessao = new SimpleStringProperty();

    public Local(){}

    public Local(int id, String codigoDaPrateleira, String numeroDaSessao) {
        setId(id);
        setCodigoDaPrateleira(codigoDaPrateleira);
        setNumeroDaSessao(numeroDaSessao);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoDaPrateleira() {
        return codigoDaPrateleira.get();
    }

    public StringProperty codigoDaPrateleiraProperty() {
        return codigoDaPrateleira;
    }

    public void setCodigoDaPrateleira(String codigoDaPrateleira) {
        this.codigoDaPrateleira.set(codigoDaPrateleira);
    }

    public String getNumeroDaSessao() {
        return numeroDaSessao.get();
    }

    public StringProperty numeroDaSessaoProperty() {
        return numeroDaSessao;
    }

    public void setNumeroDaSessao(String numeroDaSessao) {
        this.numeroDaSessao.set(numeroDaSessao);
    }

    @Override
    public String toString() { return "Prateleira: " + this.getCodigoDaPrateleira() + " | " + "Sessão: " + this.getNumeroDaSessao(); }
}
