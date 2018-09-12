package br.com.informatica.dao;

import br.com.informatica.model.Cliente;
import br.com.informatica.model.Responsavel;

import java.util.ArrayList;
import java.util.List;

public class ResponsavelJSONDAO implements ResponsavelDAO {
    @Override
    public ArrayList<Cliente> load() {
        return null;
    }

    @Override
    public void store(ListJsonDAO<Cliente> list) {

    }

    @Override
    public List filter(String filtro) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public int generateId() {
        return 0;
    }
}
