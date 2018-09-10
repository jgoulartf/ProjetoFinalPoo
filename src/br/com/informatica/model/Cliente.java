package br.com.informatica.model;

public class Cliente extends Pessoa {
    // Attributes
    private String cpf;

    // Operations
    public final boolean comprarEquipamento (Equipamento equipamento) {
        return true;
    }

    public String getCpf() {
        return cpf;
    }

    // Perguntar se pode fazer essas verificacoes aqui.
    public void setCpf(String cpf) {
        if(!cpf.isEmpty() && cpf.length() == 14) {
            this.cpf = cpf;
        }
        else {
            this.cpf = "Formato invalido ao cadastrar";
        }
    }
}
