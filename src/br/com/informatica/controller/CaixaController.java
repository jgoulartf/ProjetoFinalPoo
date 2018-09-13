package br.com.informatica.controller;

import br.com.informatica.dao.ClienteDAO;
import br.com.informatica.dao.DAOFactory;
import br.com.informatica.dao.EquipamentoDAO;
import br.com.informatica.model.Cliente;
import br.com.informatica.model.Equipamento;
import com.jfoenix.controls.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CaixaController implements Initializable {

    private EquipamentoDAO daoEquipamento = DAOFactory.getEquipamentoDAO();
    private ClienteDAO daoCliente = DAOFactory.getClienteDao();

    @FXML private JFXTextField searchEquipamentos;

    @FXML private JFXListView<Equipamento> listViewEquipamentos;

    @FXML private JFXListView<Equipamento> listViewCarrinho;

    @FXML private JFXTextField textFieldQuant;

    @FXML private JFXTextArea textAreaProduct;

    @FXML private JFXComboBox<Cliente> escolherCliente ;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            loadListView(false);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        listViewEquipamentos.getSelectionModel().selectedItemProperty().addListener((event, oldValue,newValue) -> {
            unBindListViewEstoque(oldValue);
            bindListViewEstoque(newValue);
        });

        listViewCarrinho.getSelectionModel().selectedItemProperty().addListener((event, oldValue, newValue) -> {
            unBindListViewCarrinho(oldValue);
            bindListViewCarrinho(newValue)
        });
    }

    @FXML
    private void loadListView(boolean filter){
        List<Equipamento> equipamentos;
        List<Cliente> clientes = daoCliente.load();
        if(!filter) {
            equipamentos = daoEquipamento.load();
        }
        else {
            equipamentos = daoEquipamento.filter(searchEquipamentos.getText());
        }
        listViewEquipamentos.setItems(FXCollections.observableArrayList(equipamentos));
        escolherCliente.setItems(FXCollections.observableArrayList(clientes));
    }

    @FXML
    private void adicionarProdutoCarrinho() {}


    private void bindListViewEstoque(Equipamento e) {
        if(e != null) {
            textAreaProduct.textProperty().bindBidirectional(new SimpleStringProperty(e.toString()));
            textAreaProduct.setOpacity(1);
        }

    }

    private void unBindListViewEstoque(Equipamento e) {
        if(e != null) {
            textAreaProduct.textProperty().unbindBidirectional(new SimpleStringProperty(e.toString()));
            textAreaProduct.setOpacity(0.43);
        }

    }

    @FXML
    private void onSearch() {
        loadListView(true);
    }

    public void setChangePanelCliente() throws Exception{
        ChangePanelController.setChangePanelCliente();
    }

    public void setChangePanelEstoque() throws Exception{
        ChangePanelController.setChangePanelEstoque();
    }

    public void setChangePanelResponsavel() throws Exception{
        ChangePanelController.setChangePanelResponsavel();
    }
}
