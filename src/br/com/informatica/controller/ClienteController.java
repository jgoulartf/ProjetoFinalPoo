package br.com.informatica.controller;

import br.com.informatica.application.MainApp;
import br.com.informatica.dao.ClienteJSONDAO;
import br.com.informatica.dao.ListJsonDAO;
import br.com.informatica.model.Cliente;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

public class ClienteController {

    @FXML JFXTextField searchCliente;

    @FXML JFXListView<String> listViewClientes;

    @FXML JFXTextField tfNome;

    @FXML JFXTextField tfEndereco;

    @FXML JFXTextField tfCpf;

    private ListJsonDAO listJson = new ListJsonDAO();
    private ClienteJSONDAO clienteJsonDAO = new ClienteJSONDAO();

    public void carregarListViewClientes() throws Exception {

    }

    // Perguntar se verifica os atributos aqui ou no model.
    public void cadastrarCliente() {

        // Instaciando novo cliente cadastrado
        Cliente c = new Cliente(tfNome.getText(), tfEndereco.getText(), tfCpf.getText());

        // Adicionando novo cliente ao list view
        listViewClientes.getItems().add(c.toString());

        // Limpando campos
        tfNome.clear();
        tfEndereco.clear();
        tfCpf.clear();
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
}
