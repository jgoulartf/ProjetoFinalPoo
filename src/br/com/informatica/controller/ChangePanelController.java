package br.com.informatica.controller;

import br.com.informatica.application.MainApp;
import javafx.fxml.FXML;

public class ChangePanelController {

    @FXML
    public static void setChangePanelCaixa() throws Exception {
        MainApp.changePanel("../view/FXMLCaixa.fxml", MainApp.getWidthScreen(), MainApp.getHeightScreen());
    }

    @FXML
    public static void setChangePanelCliente() throws Exception {
        MainApp.changePanel("../view/FXMLCliente.fxml", MainApp.getWidthScreen(), MainApp.getHeightScreen());
    }

    @FXML
    public static void setChangePanelEstoque() throws Exception {
        MainApp.changePanel("../view/FXMLEstoque.fxml", MainApp.getWidthScreen(), MainApp.getHeightScreen());
    }

    @FXML
    public static void setChangePanelResponsavel() throws Exception {
        MainApp.changePanel("../view/FXMLResponsavel.fxml", MainApp.getWidthScreen(), MainApp.getHeightScreen());
    }

    @FXML
    public static void setChangePanelLocal() throws Exception {
        MainApp.changePanel("../view/FXMLLocal.fxml", MainApp.getWidthScreen(), MainApp.getHeightScreen());
    }


}
