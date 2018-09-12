package br.com.informatica.controller;

import br.com.informatica.model.Equipamento;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

public class CaixaController {

    @FXML private JFXButton changePanelCaixa;

    @FXML private JFXButton changePanelCliente;

    @FXML private JFXButton changePanelEstoque;

    @FXML private JFXButton changePanelFuncionario;

    @FXML private JFXTextField searchProduct;

    @FXML private JFXListView<Equipamento> listViewProducts;

    @FXML private JFXTextField textFieldQuant;

    @FXML private JFXTextArea textAreaProduct;

    @FXML private JFXListView<Equipamento> listViewProductsBuy;

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
