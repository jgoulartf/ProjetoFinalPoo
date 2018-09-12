package br.com.informatica.dao;

import br.com.informatica.model.Cliente;
import com.google.gson.Gson;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClienteJSONDAO implements ClienteDAO {

    private Gson gson = new Gson();
    private ListJsonDAO listJsonCliente = new ListJsonDAO();

    @Override
    public ArrayList<Cliente> load() throws Exception {

        String fileJson = "/home/jglord/IdeaProjects/ProjetoFinalPoo/src/br/com/informatica/data/clientes.json";

        BufferedReader br = new BufferedReader(new FileReader(fileJson));

        listJsonCliente = gson.fromJson(br, ListJsonDAO.class);

        return listJsonCliente.getList();
    }

    @Override
    public void store(ListJsonDAO<Cliente> list) {

        String json = gson.toJson(list);
        try {
            //Escreve Json convertido em arquivo chamado "file.json"
            FileWriter writer = new FileWriter("/home/jglord/IdeaProjects/ProjetoFinalPoo/src/br/com/informatica/data/clientes.json");
            writer.write(json);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
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
