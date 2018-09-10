package br.com.informatica.controller;

import br.com.informatica.application.MainApp;
import br.com.informatica.model.LoginModel;

import com.jfoenix.controls.*;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;

public class LoginController {

    @FXML private JFXTextField JFXUsernameLogin;

    @FXML private JFXPasswordField JFXPasswordLogin;

    @FXML
    public void autenticar() throws Exception{

        LoginModel loginModel = new LoginModel();

        // Delegando a tarefa de autenticar para o LoginModel
        if( loginModel.autenticar(JFXUsernameLogin.getText(), JFXPasswordLogin.getText())) {
            MainApp.changePanel("../view/FXMLHome.fxml", MainApp.getWidthScreen(), MainApp.getHeightScreen());
        }
        else {

            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("ERRO");
            dialogoErro.setHeaderText(null);
            dialogoErro.setContentText("NOME DE USUARIO OU SENHA ERRADO(S)");
            dialogoErro.show();
            System.out.println("ERROU");
        }
     }

    public TextField getUsername() { return JFXUsernameLogin; }

    public void setUsername(JFXTextField username) { this.JFXUsernameLogin = username; }

    public TextField getPassword() { return JFXPasswordLogin; }

    public void setPassword(JFXPasswordField password) { this.JFXPasswordLogin = password; }
}
