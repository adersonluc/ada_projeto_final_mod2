package br.com.arri.model;

import java.math.BigDecimal;

public class Produto {

    private Integer id;
    private String nome;
    private String descricao;
    private Categoria categoria;
    private BigDecimal precoUnitario;
    private Boolean frete;

    public Produto(Integer id, String nome, String descricao, Categoria categoria, BigDecimal precoUnitario, Boolean frete) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.precoUnitario = precoUnitario;
        this.frete = frete;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Boolean getFrete() {
        return frete;
    }

    public void setFrete(Boolean frete) {
        this.frete = frete;
    }

    public Categoria getCategoria() { return categoria; }

    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}
