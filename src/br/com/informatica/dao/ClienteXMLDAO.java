package br.com.informatica.dao;

import br.com.informatica.model.Cliente;

import java.util.List;

public class ClienteXMLDAO implements ClienteDAO {
    @Override
    public List<Cliente> load() {
        return null;
    }

    @Override
    public void store(List<Cliente> list) {

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
