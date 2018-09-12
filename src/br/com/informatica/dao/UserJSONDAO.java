package br.com.informatica.dao;

import br.com.informatica.model.Cliente;
import br.com.informatica.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserJSONDAO implements UserDAO {
    @Override
    public ArrayList<User> load() {
        return null;
    }

    @Override
    public void store(ListJsonDAO<User> list) {

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
