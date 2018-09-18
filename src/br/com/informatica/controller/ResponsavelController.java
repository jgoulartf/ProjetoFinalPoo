package br.com.informatica.controller;

import br.com.informatica.dao.DAOFactory;
import br.com.informatica.dao.ResponsavelDAO;
import br.com.informatica.model.Cliente;
import br.com.informatica.model.Responsavel;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ResponsavelController implements Initializable {

    private ResponsavelDAO dao = DAOFactory.getResponsavelDAO();

    @FXML private JFXTextField searchResponsavel;

    @FXML private JFXListView<Responsavel> listViewResponsaveis;

    @FXML private JFXTextField tfNome;

    @FXML private JFXTextField tfEndereco;

    @FXML private JFXTextField tfTelefone;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            loadListView(false);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        listViewResponsaveis.getSelectionModel().selectedItemProperty().addListener((event, oldValue,newValue) -> {
            unBindListView(oldValue);
            bindListView(newValue);
        });
    }

    private void loadListView(boolean filter){
        List<Responsavel> responsaveis;
        if(!filter) {
            responsaveis = dao.load();
        }
        else {
            responsaveis = dao.filter(searchResponsavel.getText());
        }
        listViewResponsaveis.setItems(FXCollections.observableArrayList(responsaveis));
    }

    private void bindListView(Responsavel c) {
        if(c != null) {
            tfNome.textProperty().bindBidirectional(c.nomeProperty());
            tfEndereco.textProperty().bindBidirectional(c.enderecoProperty());
            tfTelefone.textProperty().bindBidirectional(c.telefoneProperty());
        }

    }

    private void unBindListView(Responsavel c) {
        if(c != null) {
            tfNome.textProperty().unbindBidirectional(c.nomeProperty());
            tfEndereco.textProperty().unbindBidirectional(c.enderecoProperty());
            tfTelefone.textProperty().bindBidirectional(c.telefoneProperty());
        }
    }

    @FXML
    private void onSearch() {
        loadListView(true);
    }

    @FXML
    public void cadastrarResponsavel() {

        List<Responsavel> clientes = dao.load();
        clientes.add( passFieldsValues() );

        dao.store(clientes);
        resetFieldsValues();
        loadListView(false);
    }


    @FXML
    private void atualizarResponsavel() {
        dao.store(listViewResponsaveis.getItems());
        listViewResponsaveis.getSelectionModel().clearSelection();
        resetFieldsValues();
    }

    @FXML
    private void deletarResponsavel() {
        dao.delete(listViewResponsaveis.getSelectionModel().selectedItemProperty().get().getId());
        loadListView(false);
        resetFieldsValues();
    }

    private Responsavel passFieldsValues() {
        return new Responsavel(dao.generateId(), tfNome.getText(), tfEndereco.getText(), tfTelefone.getText());
    }

    private void resetFieldsValues() {
        tfNome.clear();
        tfEndereco.clear();
        tfTelefone.clear();
    }

    public void setChangePanelCaixa() throws Exception{
        ChangePanelController.setChangePanelCaixa();
    }

    public void setChangePanelCliente() throws Exception{
        ChangePanelController.setChangePanelCliente();
    }

    public void setChangePanelEstoque() throws Exception{
        ChangePanelController.setChangePanelEstoque();
    }

    public void setChangePanelLocal() throws Exception {
        ChangePanelController.setChangePanelLocal();
    }
}
