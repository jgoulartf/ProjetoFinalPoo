package br.com.informatica.controller;

import br.com.informatica.dao.ClienteJSONDAO;
import br.com.informatica.dao.ListJsonDAO;
import br.com.informatica.model.Cliente;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;

public class ClienteController {

    @FXML JFXTextField searchCliente;

    @FXML JFXListView<Cliente> listViewClientes;

    @FXML JFXTextField tfNome;

    @FXML JFXTextField tfEndereco;

    @FXML JFXTextField tfCpf;

    ListJsonDAO listJson = new ListJsonDAO();
    ClienteJSONDAO clienteJsonDAO = new ClienteJSONDAO();

    public void carregarListViewClientes() throws Exception {

        listJson.getList() = clienteJsonDAO.load();


    }


    public void cadastrarCliente() {



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
