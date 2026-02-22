package com.example.lojinha.model.dao;
import com.example.lojinha.model.entities.Produto;

import java.util.List;

public interface ProdutoDAO {

    void inserir(Produto produto);

    void removerPorId(int id);

    double calcularTotalEstoque();

    List<Produto> listarTodos();

}
