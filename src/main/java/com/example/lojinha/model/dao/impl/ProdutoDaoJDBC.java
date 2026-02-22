package com.example.lojinha.model.dao.impl;

import com.example.lojinha.db.DB;
import com.example.lojinha.model.dao.ProdutoDAO;
import com.example.lojinha.model.entities.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDaoJDBC implements ProdutoDAO {

    private Connection conn;

    public ProdutoDaoJDBC() {
        conn = DB.conectar();
    }
    @Override
    public void inserir (Produto produto) {

        String sql = "INSERT INTO produto (id,nome, preco, quantidade, categoria, descricao) VALUES (?, ?, ?, ?, ?,?)";

        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, produto.getId());
            st.setString(2, produto.getNome());
            st.setDouble(3, produto.getPreco());
            st.setInt(4, produto.getQuantidade());
            st.setString(5, produto.getCategoria());
            st.setString(6, produto.getDescricao());

            st.executeUpdate();

            System.out.println("Produto inserido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir produto", e);
        }
    }

    @Override
    public void removerPorId(int id) {

        String sql = "DELETE FROM produto WHERE id = ?";

        try (Connection conn = DB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Produto removido com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        /**String sql = "DELETE FROM produto WHERE id = ?";

        try (PreparedStatement st = conn.prepareStatement(sql)) {

            st.setInt(1, id);
            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Produto removido com sucesso!");
            } else {
                System.out.println("Nenhum produto encontrado com esse ID.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover produto", e);
        }**/
    }
    @Override
    public List<Produto> listarTodos() {

        String sql = "SELECT * FROM produto";
        List<Produto> lista = new ArrayList<>();

        try (PreparedStatement st = conn.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {

                Produto p = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco"),
                        rs.getString("categoria"),
                        rs.getString("descricao")
                );

                lista.add(p);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar produtos", e);
        }

        return lista;
    }
    @Override
    public double calcularTotalEstoque() {

        String sql = "SELECT SUM(preco * quantidade) AS total FROM produto";
        double total = 0.0;

        try (PreparedStatement st = conn.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            if (rs.next()) {
                total = rs.getDouble("total");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao calcular total do estoque", e);
        }

        return total;
    }
}
