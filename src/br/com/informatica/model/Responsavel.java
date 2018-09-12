package br.com.informatica.model;

public class Responsavel extends Pessoa {
    // Attributes
    private String telefone;
    private Equipamento equipamentoResponsavel;

    public Responsavel(String nome, String endereco, String telefone, Equipamento equipamentoResponsavel) {
        super(nome, endereco);
        this.telefone = telefone;
        this.equipamentoResponsavel = equipamentoResponsavel;
    }

    // Operations
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Equipamento getEquipamentoResponsavel() {
        return equipamentoResponsavel;
    }

    public void setEquipamentoResponsavel(Equipamento equipamentoResponsavel) {
        this.equipamentoResponsavel = equipamentoResponsavel;
    }
}
