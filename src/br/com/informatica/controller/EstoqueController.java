package br.com.informatica.controller;

import br.com.informatica.application.MainApp;
import br.com.informatica.dao.DAOFactory;
import br.com.informatica.dao.EquipamentoDAO;
import br.com.informatica.dao.LocalDAO;
import br.com.informatica.dao.ResponsavelDAO;
import br.com.informatica.model.Equipamento;
import br.com.informatica.model.Local;
import br.com.informatica.model.Responsavel;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class EstoqueController implements Initializable {

    private EquipamentoDAO daoEquipamento = DAOFactory.getEquipamentoDAO();

    private LocalDAO daoLocal = DAOFactory.getLocalDAO();

    private ResponsavelDAO daoResponsavel = DAOFactory.getResponsavelDAO();

    @FXML JFXTextField searchEquipamentos;

    @FXML JFXListView<Equipamento> listViewEquipamentos;

    @FXML JFXTextField tfNome;

    @FXML JFXTextField tfPeso;

    @FXML JFXTextField tfPreco;

    @FXML JFXTextField tfQuantidade;

    @FXML JFXTextField tfNumeroDeSerie;

    @FXML JFXComboBox<Local> comboBoxLocal;

    @FXML JFXComboBox<Responsavel> comboBoxResponsavel;

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

        List<Local> locais = daoLocal.load();
        List<Responsavel> responsaveis = daoResponsavel.load();

        if( locais != null && responsaveis != null ) {
            comboBoxLocal.setItems(FXCollections.observableArrayList(daoLocal.load()));
            comboBoxResponsavel.setItems(FXCollections.observableArrayList(daoResponsavel.load()));
        }

    }

    private void loadListView(boolean filter){
        List<Equipamento> equipamentos;
        if(!filter) {
            equipamentos = daoEquipamento.load();
        }
        else {
            equipamentos = daoEquipamento.filter(searchEquipamentos.getText());
        }
        listViewEquipamentos.setItems(FXCollections.observableArrayList(equipamentos));
    }

    private void bindListView(Equipamento e) {
        if(e != null) {
            tfNome.textProperty().bindBidirectional(e.nomeProperty());
            tfPeso.textProperty().bindBidirectional(e.pesoProperty());
            tfPreco.textProperty().bindBidirectional(e.precoProperty());
            tfQuantidade.textProperty().bindBidirectional(e.quantidadeProperty());
            tfNumeroDeSerie.textProperty().bindBidirectional(e.numeroDeSerieProperty());
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

        List<Equipamento> equipamentos = daoEquipamento.load();

        equipamentos.add( passFieldsValues() );

        daoEquipamento.store(equipamentos);
        resetFieldsValues();
        loadListView(false);
    }


    @FXML
    private void atualizarEquipamento() {
        daoEquipamento.store(listViewEquipamentos.getItems());
        listViewEquipamentos.getSelectionModel().clearSelection();
        resetFieldsValues();
    }

    @FXML
    private void deletarEquipamento() {
        daoEquipamento.delete(listViewEquipamentos.getSelectionModel().selectedItemProperty().get().getId());
        loadListView(false);
        resetFieldsValues();
    }

    private Equipamento passFieldsValues() {
        // Gerando o novo equipamento
        return new Equipamento(daoEquipamento.generateId(), tfNome.getText(), tfPeso.getText(),
                tfPreco.getText(), tfQuantidade.getText(), tfNumeroDeSerie.getText(), comboBoxLocal.getValue(), comboBoxResponsavel.getValue());
    }

    private void resetFieldsValues() {
        tfNome.clear();
        tfPeso.clear();
        tfPreco.clear();
        tfQuantidade.clear();
        tfNumeroDeSerie.clear();
        comboBoxResponsavel.getSelectionModel().clearSelection();
        comboBoxLocal.getSelectionModel().clearSelection();
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

    public void setChangePanelLocal() throws Exception{
        ChangePanelController.setChangePanelLocal();
    }

    public void setChangePanelEstoque() throws Exception{
        ChangePanelController.setChangePanelEstoque();
    }

    public void sair() throws Exception {
        MainApp.changePanel("../view/FXMLLogin.fxml", MainApp.getWidthScreen(), MainApp.getHeightScreen());
    }
}
