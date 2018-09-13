package br.com.informatica.dao;

import br.com.informatica.exception.DAOException;
import br.com.informatica.model.Cliente;
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

public class ClienteJSONDAO implements ClienteDAO {

    private Gson gson = new GsonBuilder().registerTypeAdapter(StringProperty.class, new StringPropertyAdapter()).create();
    private static final Path STORAGE_FILE = Paths.get("out//production//ProjetoFinalPoo//br//com//informatica//data//clientes.json");

    @Override
    public List<Cliente> load() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            Type listClienteType = new TypeToken<List<Cliente>>(){}.getType();
            clientes = gson.fromJson( Files.newBufferedReader(STORAGE_FILE),listClienteType );
        }catch (Exception e){
            throw new DAOException(e);
        }
        return clientes;
    }

    @Override
    public void store(List<Cliente> list) {
        Type listClienteType = new TypeToken<List<Cliente>>(){}.getType();
        String json = gson.toJson(list,listClienteType);
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
                cliente -> cliente.getNome().toUpperCase().contains(text) ||
                           cliente.getCpf().toUpperCase().contains(text)
        ).collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        List<Cliente> clientes = this.load();

        Map<String, Cliente> map = new HashMap<String, Cliente>();

        clientes.forEach(c -> {
            map.put(String.valueOf(c.getId()), c);
        });
        clientes.remove(map.get(String.valueOf(id)));
        store(clientes);

    }

    @Override
    public int generateId() {
        return load().stream().mapToInt(c -> c.getId() + 1).max().orElse(1);
    }
}

final class StringPropertyAdapter implements JsonSerializer<StringProperty>, JsonDeserializer<StringProperty> {

    @Override
    public StringProperty deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return new SimpleStringProperty(jsonElement.getAsString());
    }

    @Override
    public JsonElement serialize(StringProperty stringProperty, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(stringProperty.get());
    }
}