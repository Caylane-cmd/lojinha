package com.example.lojinha.model.entities;

public class Produto {
    private int id;
    private String nome;
    private int Quantidade;
    private double preco;
    private String categoria;

    public Produto(int id, String nome, int quantidade, double preco, String categoria) {
        this.id= id;
        this.nome = nome;
        Quantidade = quantidade;
        this.preco = preco;
        this.categoria = categoria;
    }

    public Produto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int quantidade) {
        Quantidade = quantidade;
    }

    public double getPreco() {
        return  preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
