package br.com.informatica.controller;

import br.com.informatica.dao.DAOFactory;
import br.com.informatica.dao.EquipamentoDAO;
import br.com.informatica.model.Cliente;
import br.com.informatica.model.Equipamento;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class EstoqueController implements Initializable {

    EquipamentoDAO dao = DAOFactory.getEquipamentoDAO();

    @FXML JFXTextField searchEquipamentos;

    @FXML JFXListView<Equipamento> listViewEquipamentos;

    @FXML JFXTextField tfNome;

    @FXML JFXTextField tfPeso;

    @FXML JFXTextField tfPreco;

    @FXML JFXTextField tfQuantidade;

    @FXML JFXTextField tfNumeroDeSerie;

    @FXML JFXTextField tfLocal;

    @FXML JFXTextField tfResponsavel;

    StringConverter<Number> numberToString = new NumberStringConverter();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            loadListView(false);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        listViewEquipamentos.getSelectionModel().selectedItemProperty().addListener((event, oldValue,newValue) -> {
            unBindListView(oldValue);
            bindListView(newValue);
        });
    }



    private void loadListView(boolean filter){
        List<Equipamento> equipamentos;
        if(!filter) {
            equipamentos = dao.load();
        }
        else {
            equipamentos = dao.filter(searchEquipamentos.getText());
        }
        listViewEquipamentos.setItems(FXCollections.observableArrayList(equipamentos));
    }

    private void bindListView(Equipamento e) {
        if(e != null) {
            tfNome.textProperty().bindBidirectional(e.nomeProperty());
            tfPeso.textProperty().bindBidirectional(e.pesoProperty(), numberToString);
            tfPreco.textProperty().bindBidirectional(e.precoProperty(), numberToString);
            tfQuantidade.textProperty().bindBidirectional(e.quantidadeProperty(), numberToString);
            tfNumeroDeSerie.textProperty().bindBidirectional(e.numeroDeSerieProperty(), numberToString);
        }

    }

    private void unBindListView(Equipamento e) {
        if(e != null) {
            tfNome.textProperty().unbindBidirectional(e.nomeProperty());
            tfPeso.textProperty().unbindBidirectional(e.pesoProperty());
            tfPreco.textProperty().unbindBidirectional(e.precoProperty());
            tfQuantidade.textProperty().unbindBidirectional(e.quantidadeProperty());
            tfNumeroDeSerie.textProperty().unbindBidirectional(e.numeroDeSerieProperty());
        }

    }

    @FXML
    private void onSearch() {
        loadListView(true);
    }

    // Perguntar se verifica os atributos aqui ou no model.
    @FXML
    public void cadastrarEquipamento() {

        List<Equipamento> equipamentos = dao.load();
        equipamentos.add( passFieldsValues() );

        dao.store(equipamentos);
        resetFieldsValues();
        loadListView(false);
    }


    public void setChangePanelCaixa() throws Exception{
        ChangePanelController.setChangePanelCaixa();
    }

    public void setChangePanelCliente() throws Exception{
        ChangePanelController.setChangePanelCliente();
    }

    public void setChangePanelResponsavel() throws Exception{
        ChangePanelController.setChangePanelResponsavel();
    }

    private Cliente passFieldsValues() {
        return new Equipamento(dao.generateId(), tfNome.getText(),)
    }

    private void resetFieldsValues() {
        tfNome.textProperty().set("");
        tfEndereco.textProperty().set("");
        tfCpf.textProperty().set("");
    }


}
