package br.com.informatica.controller;

import br.com.informatica.application.MainApp;
import br.com.informatica.dao.DAOFactory;
import br.com.informatica.dao.LocalDAO;
import br.com.informatica.model.Equipamento;
import br.com.informatica.model.Local;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LocalController implements Initializable {

    private LocalDAO dao = DAOFactory.getLocalDAO();

    @FXML private JFXTextField searchLocais;

    @FXML private JFXListView<Local> listViewLocais;

    @FXML private JFXTextField tfCodigoDaPrateleira;

    @FXML private JFXTextField tfNumeroDaSessao;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            loadListView(false);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        listViewLocais.getSelectionModel().selectedItemProperty().addListener((event, oldValue,newValue) -> {
            unBindListView(oldValue);
            bindListView(newValue);
        });
    }

    private void loadListView(boolean filter){
        List<Local> equipamentos;
        if(!filter) {
            equipamentos = dao.load();
        }
        else {
            equipamentos = dao.filter(searchLocais.getText());
        }
        listViewLocais.setItems(FXCollections.observableArrayList(equipamentos));
    }

    private void bindListView(Local l) {
        if(l != null) {
            tfCodigoDaPrateleira.textProperty().bindBidirectional(l.codigoDaPrateleiraProperty());
            tfNumeroDaSessao.textProperty().bindBidirectional(l.numeroDaSessaoProperty());
        }
    }

    private void unBindListView(Local l) {
        if(l != null) {
            tfCodigoDaPrateleira.textProperty().unbindBidirectional(l.codigoDaPrateleiraProperty());
            tfNumeroDaSessao.textProperty().unbindBidirectional(l.numeroDaSessaoProperty());
        }
    }

    @FXML
    private void onSearch() {
        loadListView(true);
    }

    @FXML
    public void cadastrarLocal() {

        List<Local> equipamentos = dao.load();

        equipamentos.add( passFieldsValues() );

        dao.store(equipamentos);
        resetFieldsValues();
        loadListView(false);
    }

    @FXML
    private void atualizarLocal() {
        dao.store(listViewLocais.getItems());
        listViewLocais.getSelectionModel().clearSelection();
        resetFieldsValues();
    }

    @FXML
    private void deletarLocal() {
        dao.delete(listViewLocais.getSelectionModel().selectedItemProperty().get().getId());
        loadListView(false);
        resetFieldsValues();
    }

    private Local passFieldsValues() {
        // Gerando o novo Local
        return new Local(dao.generateId(), tfCodigoDaPrateleira.getText(), tfNumeroDaSessao.getText());
    }

    private void resetFieldsValues() {
        tfCodigoDaPrateleira.clear();
        tfNumeroDaSessao.clear();
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
