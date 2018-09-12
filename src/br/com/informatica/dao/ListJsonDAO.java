package br.com.informatica.dao;

import java.util.ArrayList;

// Classe cria um ArrayList do tipo passado e é usada para trabalhar com arquivo JSON
public class ListJsonDAO<T> {
    private ArrayList<T> list;

    public ListJsonDAO() {
        list = new ArrayList<T>();
    }

    public ArrayList<T> getList() {
        return list;
    }

    public void setList(ArrayList<T> list) {
        this.list = list;
    }
}
