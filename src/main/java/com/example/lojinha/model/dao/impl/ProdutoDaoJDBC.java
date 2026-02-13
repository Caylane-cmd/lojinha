package com.example.lojinha.model.dao.impl;

import com.example.lojinha.db.DB;
import com.example.lojinha.model.dao.ProdutoDAO;
import com.example.lojinha.model.entities.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ProdutoDaoJDBC implements ProdutoDAO {
    private Connection conn;

    public ProdutoDaoJDBC() {
        conn = DB.conectar();
    }
    public void inserir(Produto produto) {
        String sql = "INSERT INTO produto (nome, preco, quantidade, categoria) VALUES (?, ?, ?,?)";
        try (PreparedStatement st = conn.prepareStatement(sql)) {

            st.setString(1, produto.getNome());
            st.setDouble(2, produto.getPreco());
            st.setInt(3, produto.getQuantidade());
            st.setString(4, produto.getCategoria());

            st.executeUpdate();

            System.out.println("Produto inserido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir produto", e);
        }

        System.out.println("Inserindo produto...");
    }

    public void removerPorId(int id) {
       String  sql= "DELETE FROM Produto WHERE id = ?";
        System.out.println("Removendo produto...");
    }

    public double calcularTotalEstoque() {
        System.out.println("Calculando total...");
        return 0.0;
    }
}
