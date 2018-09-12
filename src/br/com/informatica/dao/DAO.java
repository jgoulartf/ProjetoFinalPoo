package br.com.informatica.dao;

import br.com.informatica.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public interface DAO<T> {

    public ArrayList<Cliente> load() throws Exception;

    public void store(ListJsonDAO<Cliente> list);

    public List filter(String filtro);

    public void delete(int id);

    public int generateId();

}
