package com.example.lojinha;

import com.example.lojinha.model.dao.ProdutoDAO;
import com.example.lojinha.model.dao.impl.ProdutoDaoJDBC;
import com.example.lojinha.model.entities.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private Label welcomeText;

    @FXML
    private TextField campoId;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoQuantidade;

    @FXML
    private TextField campoPreco;

    @FXML
    private TextField campoCategoria;

    @FXML
    private TextField campoDescricao;

    @FXML
    private void botaoAdicionar() {
        int id = Integer.parseInt(campoId.getText());
        String nome = campoNome.getText();
        int quantidade = Integer.parseInt(campoQuantidade.getText());
        double preco = Double.parseDouble(campoPreco.getText());
        String categoria = campoCategoria.getText();
        String descricao = campoDescricao.getText();

        Produto produto = new Produto(id, nome, quantidade, preco, categoria, descricao);

        ProdutoDAO dao = new ProdutoDaoJDBC() ;

        dao.inserir(produto);

        carregarProdutos();

    }

    @FXML
    private void botaoRemover() {
        if (campoId.getText().isEmpty()) {
            System.out.println("Digite um ID para remover.");
            return;
        }

        int id = Integer.parseInt(campoId.getText());

        ProdutoDAO dao = new ProdutoDaoJDBC();
        dao.removerPorId(id);

        carregarProdutos();
    }

    @FXML
    private TableView<Produto> tabelaProdutos;

    @FXML
    private TableColumn<Produto, Integer> colId;

    @FXML
    private TableColumn<Produto, String> colNome;

    @FXML
    private TableColumn<Produto, Integer> colQuantidade;

    @FXML
    private TableColumn<Produto, Double> colPreco;

    @FXML
    private TableColumn<Produto, String> colCategoria;

    @FXML
    private TableColumn<Produto, String> colDescricao;


    private ObservableList<Produto> listaProdutos = FXCollections.observableArrayList();

    private void carregarProdutos() {

        ProdutoDAO dao = new ProdutoDaoJDBC();

        listaProdutos.clear();

        var lista = dao.listarTodos();
        System.out.println("Quantidade no banco: " + lista.size());

        listaProdutos.addAll(lista);
        tabelaProdutos.refresh();

        for (Produto p : lista) {
            System.out.println(p.getNome());
        }
       /** ProdutoDAO dao = new ProdutoDaoJDBC();

        listaProdutos.clear();
**/    }

    @FXML
    public void initialize() {

        colId.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleIntegerProperty(
                        cellData.getValue().getId()
                ).asObject()
        );

        colNome.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(
                        cellData.getValue().getNome()
                )
        );

        colQuantidade.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleIntegerProperty(
                        cellData.getValue().getQuantidade()
                ).asObject()
        );

        colPreco.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleDoubleProperty(
                        cellData.getValue().getPreco()
                ).asObject()
        );

        colCategoria.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(
                        cellData.getValue().getCategoria()
                )
        );

        colDescricao.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleStringProperty(
                        cellData.getValue().getDescricao()
                )
        );



        tabelaProdutos.setItems(listaProdutos);

        carregarProdutos();
    }

   /** public void setColCategoria(TableColumn<Produto, String> colCategoria) {
        this.colCategoria = colCategoria;
    }**/
}



