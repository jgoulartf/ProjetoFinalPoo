package br.com.informatica.dao;

import br.com.informatica.exception.DAOException;
import br.com.informatica.model.Cliente;
import br.com.informatica.model.Equipamento;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EquipamentoJSONDAO implements EquipamentoDAO {

    private Gson gson = new GsonBuilder().registerTypeAdapter(StringProperty.class, new StringPropertyAdapter()).create();
    private static final Path STORAGE_FILE = Paths.get("out//production//ProjetoFinalPoo//br//com//informatica//data//equipamentos.json");

    @Override
    public List<Equipamento> load() {
        List<Equipamento> equipamentos = new ArrayList<Equipamento>();
        try {
            Type listEquipamentoType = new TypeToken<List<Equipamento>>(){}.getType();
            equipamentos = gson.fromJson( Files.newBufferedReader(STORAGE_FILE),listEquipamentoType );
        }catch (Exception e){
            throw new DAOException(e);
        }
        return equipamentos;
    }

    @Override
    public void store(List<Equipamento> list) {
        Type listEquipamentoType = new TypeToken<List<Equipamento>>(){}.getType();
        String json = gson.toJson(list,listEquipamentoType);
        try {
            Files.write(STORAGE_FILE, json.getBytes());

        }catch (Exception e){
            throw new DAOException(e);
        }

    }

    @Override
    public List filter(String filtro) {
        String text = filtro.toUpperCase();
        return load().stream().filter(
                equipamento -> equipamento.getNome().toUpperCase().contains(text) ||
                        String.valueOf(equipamento.getNumeroDeSerie()).toUpperCase().contains(text)
        ).collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        List<Equipamento> equipamentos = this.load();

        Map<String, Equipamento> map = new HashMap<String, Equipamento>();

        equipamentos.forEach(e -> {
            map.put(String.valueOf(e.getId()), e);
        });
        equipamentos.remove(map.get(String.valueOf(id)));
        store(equipamentos);

    }

    @Override
    public int generateId() {
        return load().stream().mapToInt(c -> c.getId() + 1).max().orElse(1);
    }
}
