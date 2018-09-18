package br.com.informatica.controller;

import br.com.informatica.dao.ClienteDAO;
import br.com.informatica.dao.DAOFactory;
import br.com.informatica.dao.EquipamentoDAO;
import br.com.informatica.model.Cliente;
import br.com.informatica.model.Equipamento;
import br.com.informatica.model.NotaDeVenda;
import com.jfoenix.controls.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CaixaController implements Initializable {

    private EquipamentoDAO daoEquipamento = DAOFactory.getEquipamentoDAO();

    private ClienteDAO daoCliente = DAOFactory.getClienteDao();

    private List<Equipamento> carrinho = new ArrayList<Equipamento>();

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

//        listViewCarrinho.getSelectionModel().selectedItemProperty().addListener((event, oldValue, newValue) -> {
//            unBindListViewCarrinho(oldValue);
//            bindListViewCarrinho(newValue)
//        });
    }

    @FXML
    private void loadListView(boolean filter){
        List<Equipamento> equipamentos;
        if(!filter) {
            equipamentos = daoEquipamento.load();
        }
        else {
            equipamentos = daoEquipamento.filter(searchEquipamentos.getText());
        }
        listViewEquipamentos.setItems(FXCollections.observableArrayList(equipamentos));
        escolherCliente.setItems(FXCollections.observableArrayList(daoCliente.load()));
    }

    @FXML
    private void adicionarProdutoCarrinho() {

        if( Integer.parseInt(textFieldQuant.getText()) <=
                Integer.parseInt(listViewEquipamentos.getSelectionModel().getSelectedItem().getQuantidade())){

            // Criando novo equipamento "e" para nao acessar a referencia do ListView e evitar a mudanca de valores no canto errado
            Equipamento daLista = listViewEquipamentos.getSelectionModel().getSelectedItem();
            Equipamento e = new Equipamento(daoEquipamento.generateId(), daLista.getNome(), daLista.getPeso(), daLista.getPreco(), daLista.getQuantidade(),
                    daLista.getNumeroDeSerie(), daLista.getLocal(), daLista.getResponsavel());


            int quantidade1 = Integer.parseInt(listViewEquipamentos.getSelectionModel().getSelectedItem().quantidadeProperty().getValue());

            int novaQuantidade = quantidade1 - Integer.parseInt(textFieldQuant.getText());
            listViewEquipamentos.getSelectionModel().getSelectedItem().setQuantidade(String.valueOf(novaQuantidade));
            listViewEquipamentos.refresh();

            e.setQuantidade(textFieldQuant.getText());

            carrinho.add(e);

            if(carrinho != null) {
                listViewCarrinho.setItems(FXCollections.observableArrayList(carrinho));
            }

            textFieldQuant.clear();
        }
        else {
            Alert dialogoErro = new Alert(Alert.AlertType.WARNING);
            dialogoErro.setTitle("QUANTIDADE EXCEDIDA");
            dialogoErro.setHeaderText(null);
            dialogoErro.setContentText("Quantidade de produtos não atendida pelo estoque");
            dialogoErro.showAndWait();
        }

    }

    @FXML
    private void finalizarPedido() {
        Cliente c = escolherCliente.getSelectionModel().getSelectedItem();
        if( c == null) {
            Alert dialogoErro = new Alert(Alert.AlertType.ERROR);
            dialogoErro.setTitle("SEM ESCOLHA DE CLIENTE");
            dialogoErro.setHeaderText(null);
            dialogoErro.setContentText("Escolha o cliente responsável pela compra");
        }
        else if( carrinho.size() > 0 ) {

            Alert dialogoErro = new Alert(Alert.AlertType.CONFIRMATION);
            dialogoErro.setTitle("FINALIZAR PEDIDO");
            dialogoErro.setHeaderText(null);
            dialogoErro.setContentText("Deseja finalizar seu pedido e emitir a nota de venda?");
            dialogoErro.showAndWait().ifPresent(response -> {
                if( response == ButtonType.OK ) {
                    // Salvando novos valores no arquivo JSON
                    daoEquipamento.store(listViewEquipamentos.getItems());
                    emitirNotaDeVenda();
                    System.out.println("Entrei no teste!");
                }
            });

        }
        else {
            Alert dialogoErro = new Alert(Alert.AlertType.WARNING);
            dialogoErro.setTitle("CARRINHO VAZIO");
            dialogoErro.setHeaderText(null);
            dialogoErro.setContentText("Adicione mais produtos no carrinho!");
            dialogoErro.showAndWait();
        }
    }

    private void emitirNotaDeVenda() {
        double precoTotal = 0.0;
        String notaTxt;

        Path STORAGE_FILE = Paths.get("out//production//ProjetoFinalPoo//br//com//informatica//nota");

        // Calculando preco total
        for(Equipamento e: carrinho) {
            precoTotal += Double.parseDouble(e.getPreco()) * Double.parseDouble(e.getQuantidade());
        }

        NotaDeVenda nota = new NotaDeVenda(escolherCliente.getSelectionModel().getSelectedItem(), new Date(), carrinho);

        try {
            Files.write(STORAGE_FILE, nota.toString().getBytes());
            System.out.println("Escrevi no arquivo!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void onSearch() {
        loadListView(true);
    }

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

    public void setChangePanelCliente() throws Exception{
        ChangePanelController.setChangePanelCliente();
    }

    public void setChangePanelEstoque() throws Exception{
        ChangePanelController.setChangePanelEstoque();
    }

    public void setChangePanelResponsavel() throws Exception{
        ChangePanelController.setChangePanelResponsavel();
    }

    public void setChangePanelLocal() throws Exception {
        ChangePanelController.setChangePanelLocal();
    }

}
