package br.com.informatica.dao;


import java.util.ArrayList;
import java.util.List;

public interface DAO<T> {

    public List<T> load();

    public void store(List<T> list);

    public List filter(String filtro);

    public void delete(int id);

    public int generateId();

}
