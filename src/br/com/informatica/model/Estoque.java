package br.com.informatica.model;

import java.util.ArrayList;

public class Estoque {
    // Associations
    // Attributes
    private ArrayList<Equipamento> equipamentos;
    // Operations
    public final boolean cadastrarEquipamento () {
        return true;
    }

    public ArrayList<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(ArrayList<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }
}
