package br.com.informatica.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Classe cria um ArrayList do tipo passado e é usada para trabalhar com arquivo JSON
public class ListJsonDAO<T> implements Serializable{
    private List<T> list;


    public ListJsonDAO() {
        list = new ArrayList<T>();
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
