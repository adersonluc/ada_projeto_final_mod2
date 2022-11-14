package br.com.arri.model;

import java.math.BigDecimal;

public class Pedido {

    private Integer idPedido;
    private Integer idProduto;
    private Integer quantidadeProduto;
    private BigDecimal precoTotal;

    public Integer getIdPedido() {
        return idPedido;
    }

    public Pedido(Integer idPedido, Integer idProduto, Integer quantidadeProduto, BigDecimal precoTotal) {
        this.idPedido = idPedido;
        this.idProduto = idProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.precoTotal = precoTotal;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Integer quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public BigDecimal getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(BigDecimal precoTotal) {
        this.precoTotal = precoTotal;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", idProduto=" + idProduto +
                ", quantidadeProduto=" + quantidadeProduto +
                ", precoTotal=" + precoTotal +
                "}";
    }

}
