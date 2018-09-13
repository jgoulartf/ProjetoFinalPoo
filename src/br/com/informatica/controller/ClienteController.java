package br.com.informatica.controller;

import br.com.informatica.application.MainApp;
import br.com.informatica.dao.ClienteDAO;
import br.com.informatica.dao.ClienteJSONDAO;
import br.com.informatica.dao.DAOFactory;
import br.com.informatica.dao.ListJsonDAO;
import br.com.informatica.model.Cliente;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ClienteController implements Initializable {

    private ClienteDAO dao = DAOFactory.getClienteDao();

    @FXML JFXTextField searchCliente;

    @FXML JFXListView<Cliente> listViewClientes;

    @FXML JFXTextField tfNome;

    @FXML JFXTextField tfEndereco;

    @FXML JFXTextField tfCpf;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            loadListView(false);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        listViewClientes.getSelectionModel().selectedItemProperty().addListener((event, oldValue,newValue) -> {
            unBindListView(oldValue);
            bindListView(newValue);
        });
    }

    private void loadListView(boolean filter){
        List<Cliente> clientes;
        if(!filter) {
            clientes = dao.load();
        }
        else {
            clientes = dao.filter(searchCliente.getText());
        }
        listViewClientes.setItems(FXCollections.observableArrayList(clientes));
    }

    private void bindListView(Cliente c) {
        if(c != null) {
            tfNome.textProperty().bindBidirectional(c.nomeProperty());
            tfEndereco.textProperty().bindBidirectional(c.enderecoProperty());
            tfCpf.textProperty().bindBidirectional(c.cpfProperty());
        }

    }

    private void unBindListView(Cliente c) {
        if(c != null) {
            tfNome.textProperty().unbindBidirectional(c.nomeProperty());
            tfEndereco.textProperty().unbindBidirectional(c.enderecoProperty());
            tfCpf.textProperty().unbindBidirectional(c.cpfProperty());
        }

    }

    @FXML
    private void onSearch() {
        loadListView(true);
    }

    // Perguntar se verifica os atributos aqui ou no model.
    @FXML
    public void cadastrarCliente() {

            List<Cliente> clientes = dao.load();
            clientes.add( passFieldsValues() );

            dao.store(clientes);
            resetFieldsValues();
            loadListView(false);
    }

    @FXML
    private void atualizarCliente() {
        dao.store(listViewClientes.getItems());
        listViewClientes.getSelectionModel().clearSelection();
        resetFieldsValues();
    }
    @FXML
    private void deletarCliente() {
        dao.delete(listViewClientes.getSelectionModel().selectedItemProperty().get().getId());
        loadListView(false);
        resetFieldsValues();
    }

    public void sair() throws Exception {

        MainApp.changePanel("../view/FXMLLogin.fxml", MainApp.getWidthScreen(), MainApp.getHeightScreen());

    }

    public void setChangePanelCaixa() throws Exception{
        ChangePanelController.setChangePanelCaixa();
    }

    public void setChangePanelEstoque() throws Exception{
        ChangePanelController.setChangePanelEstoque();
    }

    public void setChangePanelResponsavel() throws Exception{
        ChangePanelController.setChangePanelResponsavel();
    }

    private Cliente passFieldsValues() {
        return new Cliente(dao.generateId(), tfNome.getText(), tfEndereco.getText(), tfCpf.getText());
    }

    private void resetFieldsValues() {
        tfNome.textProperty().set("");
        tfEndereco.textProperty().set("");
        tfCpf.textProperty().set("");
    }

}
