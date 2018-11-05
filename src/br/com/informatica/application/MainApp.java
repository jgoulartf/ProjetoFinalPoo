package br.com.informatica.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class MainApp extends Application {

    private static Stage currentStage;
    private static final int WIDTH_SCREEN = 848;
    private static final int HEIGHT_SCREEN = 452;

    @Override
    public void start(Stage mainStage) throws Exception {
        MainApp.currentStage = mainStage;

        MainApp.changePanel("../view/FXMLLogin.fxml", MainApp.WIDTH_SCREEN, MainApp.HEIGHT_SCREEN);
    }

    public static void changePanel(String fxmlResource, int width, int height) throws Exception {

        Parent root;
        URL fxmlURL;
        try {

            fxmlURL = MainApp.class.getResource(fxmlResource);
            root = FXMLLoader.load(fxmlURL);

            Scene scene = new Scene(root, MainApp.getWidthScreen(), MainApp.getHeightScreen());

            MainApp.getCurrentStage().setScene(scene);
            MainApp.getCurrentStage().centerOnScreen();
            MainApp.getCurrentStage().setTitle("INFORMÁTICA");
            MainApp.getCurrentStage().show();
            System.out.println("eu estou aqui");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Stage getCurrentStage() {
        return currentStage;
    }

    public static void setCurrentStage(Stage currentStage) {
        MainApp.currentStage = currentStage;
    }

    public static int getWidthScreen() {
        return WIDTH_SCREEN;
    }

    public static int getHeightScreen() {
        return HEIGHT_SCREEN;
    }

    public static void main(String[] args) { launch(args); }
}
