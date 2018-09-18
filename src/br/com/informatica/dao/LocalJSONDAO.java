package br.com.informatica.dao;

import br.com.informatica.exception.DAOException;
import br.com.informatica.model.Cliente;
import br.com.informatica.model.Local;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
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

public class LocalJSONDAO implements LocalDAO {

    private Gson gson = new GsonBuilder().registerTypeAdapter(StringProperty.class, new StringPropertyAdapter()).create();

    private static final Path STORAGE_FILE = Paths.get("out//production//ProjetoFinalPoo//br//com//informatica//data//locais.json");


    @Override
    public List<Local> load() {
        List<Local> locais = new ArrayList<Local>();
        try {
            Type listLocalType = new TypeToken<List<Local>>(){}.getType();
            locais = gson.fromJson( Files.newBufferedReader(STORAGE_FILE),listLocalType );
        }catch (Exception e){
            throw new DAOException(e);
        }
        return locais;
    }

    @Override
    public void store(List<Local> list) {
        Type listLocalType = new TypeToken<List<Cliente>>(){}.getType();
        String json = gson.toJson(list,listLocalType);
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
                local -> local.getCodigoDaPrateleira().toUpperCase().contains(text) ||
                        local.getNumeroDaSessao().toUpperCase().contains(text)
        ).collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        List<Local> locais = this.load();

        Map<String, Local> map = new HashMap<String, Local>();

        locais.forEach(c -> {
            map.put(String.valueOf(c.getId()), c);
        });
        locais.remove(map.get(String.valueOf(id)));
        store(locais);
    }

    @Override
    public int generateId() {
        return load().stream().mapToInt(c -> c.getId() + 1).max().orElse(1);
    }

}
