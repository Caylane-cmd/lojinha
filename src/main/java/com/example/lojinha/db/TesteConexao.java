package com.example.lojinha.db;

import com.example.lojinha.model.dao.ProdutoDAO;
import com.example.lojinha.model.dao.impl.ProdutoDaoJDBC;

public class TesteConexao {
    public static void main(String[] args) {

        ProdutoDAO dao = new ProdutoDaoJDBC();

        /**Produto p = new Produto();
        p.setId(1);
        p.setNome("Dipirona");
        p.setPreco((double)12.50);
        p.setQuantidade(10);
        p.setCategoria("Medicamento");

        dao.inserir(p);

        Produto b = new Produto();
        b.setId(2);
        b.setNome("paracetamol");
        b.setPreco((double)11.50);
        b.setQuantidade(15);
        b.setCategoria("Medicamento");

        dao.inserir(b);

        Produto c = new Produto();
        c.setId(2);
        c.setNome("Fralda M");
        c.setPreco((double)54.90);
        c.setQuantidade(15);
        c.setCategoria("Cuidados com o bebe");

        dao.inserir(c);**/

        dao.removerPorId(6);

        dao.calcularTotalEstoque();

    }

    /**  Connection conn = null;

      try {
          conn = DB.conectar();

          if (conn != null && !conn.isClosed()) {
              System.out.println(" Conexão com PostgreSQL realizada com sucesso!");
          } else {
              System.out.println(" Conexão falhou.");
          }

      } catch (Exception e) {
          System.out.println(" Erro ao conectar no banco:");
          e.printStackTrace();

      } finally {
          try {
              if (conn != null) {
                  conn.close();
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
      }**/
    }

