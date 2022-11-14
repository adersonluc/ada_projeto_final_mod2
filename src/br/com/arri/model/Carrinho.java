package br.com.arri.model;

public interface Carrinho {

    void listarItensCarrinho();
    void adicionarProduto(Produto produto);
    void removerProduto(Produto produto);
    void alterarQuantidade(Integer quantidade, Produto produto);
    void calcularFrete();
    void calculaTaxa(Produto produto, Categoria categoria);

}
