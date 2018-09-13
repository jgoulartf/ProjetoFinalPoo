package br.com.informatica.model;

public class Responsavel extends Pessoa {
    // Attributes
    private String telefone;

    public Responsavel(){}

    public Responsavel(String nome, String endereco, String telefone){
        super(nome, endereco);
        this.telefone = telefone;
    }

    // Operations
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
